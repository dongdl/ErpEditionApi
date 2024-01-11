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
import vn.com.bvb.constants.RecruitmentApprovalDetailType;
import vn.com.bvb.dto.DirectManagerApprovalDTO;
import vn.com.bvb.dto.EmployeeDTO;
import vn.com.bvb.dto.SeniorDirectManagerApprovalDTO;
import vn.com.bvb.entity.ApprovalDetail;
import vn.com.bvb.entity.Employee;
import vn.com.bvb.entity.RecruitmentUserTask;
import vn.com.bvb.mapper.EmployeeMappingManager;
import vn.com.bvb.repository.ApprovalDetailRepository;
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
	
	private ApprovalDetailRepository approvalDetailRepository;
	
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
	    
	    taskService.setAssignee(task.getId(), "user");
	    
		Map<String, Object> assigneeVariables = new HashMap<>();
		assigneeVariables.put("directManager", "manager1");
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
		
		ApprovalDetail approvalDetail = ApprovalDetail.builder()
				.employeeId(directManagerApprovalDTO.getEmployeeId())
				.taskId(taskId)
				.type(RecruitmentApprovalDetailType.DIRECT_MANAGER)
				.action("SUBMIT")
				.commentCode(directManagerApprovalDTO.getCommentCode())
				.commentTitle(directManagerApprovalDTO.getCommentTitle())
				.commentDetail(directManagerApprovalDTO.getCommentDetail())
				.build();
		approvalDetailRepository.save(approvalDetail);
		
		Map<String, Object> assigneeVariables = new HashMap<>();
		assigneeVariables.put("seniorDirectManager", "manager2");
	    taskService.complete(taskId, assigneeVariables);
	}
	
	@Override
	@Transactional
	public void approveEmployee(SeniorDirectManagerApprovalDTO seniorDirectManagerApprovalDTO) {
		long recruitmentUserTaskId = seniorDirectManagerApprovalDTO.getRecruitmentUserTaskId();
		RecruitmentUserTask recruitmentUserTask = recruitmentUserTaskRepository.findById(recruitmentUserTaskId)
				.orElseThrow(() -> new IllegalArgumentException("RecuitmentUserTask = " + recruitmentUserTaskId + " not existing!!!"));
		
		String taskId = recruitmentUserTask.getTaskId();
		
		ApprovalDetail approvalDetail = ApprovalDetail.builder()
				.employeeId(seniorDirectManagerApprovalDTO.getEmployeeId())
				.taskId(taskId)
				.type(RecruitmentApprovalDetailType.SENIOR_DIRECT_MANAGER)
				.action(seniorDirectManagerApprovalDTO.getAction())
				.commentCode(seniorDirectManagerApprovalDTO.getCommentCode())
				.commentTitle(seniorDirectManagerApprovalDTO.getCommentTitle())
				.commentDetail(seniorDirectManagerApprovalDTO.getCommentDetail())
				.build();
		approvalDetailRepository.save(approvalDetail);
		
		Map<String, Object> assigneeVariables = new HashMap<>();
	    taskService.complete(taskId, assigneeVariables);
	}


}