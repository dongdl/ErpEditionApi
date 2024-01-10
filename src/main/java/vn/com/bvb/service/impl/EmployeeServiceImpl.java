package vn.com.bvb.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.TaskService;
import org.camunda.bpm.engine.runtime.ProcessInstanceWithVariables;
import org.camunda.bpm.engine.task.Task;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.ImmutableMap;

import lombok.AllArgsConstructor;
import vn.com.bvb.constants.ProcessDefinitionKeys;
import vn.com.bvb.dto.EmployeeDTO;
import vn.com.bvb.entity.Employee;
import vn.com.bvb.mapper.EmployeeMappingManager;
import vn.com.bvb.repository.EmployeeRepository;
import vn.com.bvb.service.EmployeeService;
import vn.com.bvb.utils.EmployeeUtils;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
	
	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	private ProcessEngine processEngine;
	
	private TaskService taskService;
	
	private EmployeeRepository employeeRepository;
	
	private EmployeeMappingManager employeeMappingManager;
	
	@Override
	@Transactional(readOnly = true)
	public EmployeeDTO findByCode(String code) {
		Employee employee = employeeRepository.findByCode(code)
				.orElseThrow(() -> new IllegalArgumentException("Employee is not existing with code " + code));
		return employeeMappingManager.map(employee);
	}

	@Override
	@Transactional
	public EmployeeDTO recruitEmployee(EmployeeDTO employeeDTO) {
		String employeeCode = EmployeeUtils.generateEmployeeCode();
		employeeDTO.setCode(employeeCode);
		Employee employee = employeeMappingManager.map(employeeDTO);
		
		employeeRepository.save(employee);
		
		Map<String, Object> variables = new HashMap<>();
		
		variables.put("action", ImmutableMap.of("value", "FULL", "type", "String"));
		variables.put("twoEyesApprovalAction", ImmutableMap.of("value", "APPROVE", "type", "String"));
		variables.put("existingPosition", ImmutableMap.of("value", "FALSE", "type", "String"));
		
	    ProcessInstanceWithVariables instance = processEngine.getRuntimeService().
	    		createProcessInstanceByKey(ProcessDefinitionKeys.EmployeeKeys.RECRUITMENT)
		        .setVariables(variables)
		        .businessKey(employeeCode)
		        .executeWithVariablesInReturn();
	    
	    logger.info("Created Recruitement Process with businessKey={}, processIntanceId={}",
	    		instance.getBusinessKey(), 
	    		instance.getProcessInstanceId());
	    
	    String processInstanceId = instance.getProcessInstanceId();
	    Task task = taskService.createTaskQuery()
	    		.processInstanceId(processInstanceId)
	    		.singleResult();
	    
	    taskService.setAssignee(task.getId(), "demo");
	    taskService.complete(task.getId());
	    
	    return employeeMappingManager.map(employee);
		
	}

}