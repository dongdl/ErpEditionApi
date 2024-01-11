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

import lombok.AllArgsConstructor;
import vn.com.bvb.constants.ProcessDefinitionKeys;
import vn.com.bvb.dto.DirectManagerApprovalDTO;
import vn.com.bvb.dto.EmployeeDTO;
import vn.com.bvb.entity.Employee;
import vn.com.bvb.entity.RecruitmentUserTask;
import vn.com.bvb.mapper.EmployeeMappingManager;
import vn.com.bvb.repository.EmployeeRepository;
import vn.com.bvb.repository.RecruitmentUserTaskRepository;
import vn.com.bvb.service.EmployeeService;
import vn.com.bvb.utils.EmployeeUtils;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
	
	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	private ProcessEngine processEngine;
	
	private TaskService taskService;
	
	private EmployeeRepository employeeRepository;
	
	private RecruitmentUserTaskRepository recruitmentUserTaskRepository;
	
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
		variables.put("existingPosition", false);
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
	    
		Map<String, Object> assigneeVariables = new HashMap<>();
		assigneeVariables.put("directManager", "someone");
	    taskService.complete(task.getId(), assigneeVariables);
	    
	    return employeeMappingManager.map(employee);
		
	}

	@Override
	@Transactional
	public void approveEmployee(DirectManagerApprovalDTO directManagerApprovalDTO) {
		long recruitmentUserTaskId = directManagerApprovalDTO.getRecruitmentUserTaskId();
		RecruitmentUserTask recruitmentUserTask = recruitmentUserTaskRepository.findById(recruitmentUserTaskId)
				.orElseThrow(() -> new IllegalArgumentException("RecuitmentUserTask = " + recruitmentUserTaskId + " not existing!!!"));
		
		String taskId = recruitmentUserTask.getTaskId();
		Map<String, Object> assigneeVariables = new HashMap<>();
		assigneeVariables.put("seniorDirectManager", "someone");
	    taskService.complete(taskId, assigneeVariables);
	
	}

}