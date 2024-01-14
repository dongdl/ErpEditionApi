package vn.com.bvb.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.TaskService;
import org.camunda.bpm.engine.runtime.ProcessInstanceWithVariables;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import lombok.AllArgsConstructor;
import vn.com.bvb.constants.ProcessDefinitionKeys;
import vn.com.bvb.constants.RecruitmentApprovalDetailType;
import vn.com.bvb.dto.DirectManagerApprovalDTO;
import vn.com.bvb.dto.EmployeeDTO;
import vn.com.bvb.dto.LaborStaffApprovalDTO;
import vn.com.bvb.dto.SeniorDirectManagerApprovalDTO;
import vn.com.bvb.entity.ApprovalDetail;
import vn.com.bvb.entity.Employee;
import vn.com.bvb.entity.Family;
import vn.com.bvb.entity.RecruitmentUserTask;
import vn.com.bvb.mapper.EmployeeMappingManager;
import vn.com.bvb.repository.ApprovalDetailRepository;
import vn.com.bvb.repository.EmployeeRepository;
import vn.com.bvb.repository.FamilyRepository;
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
	
	private FamilyRepository familyRepository;
	
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
	public EmployeeDTO startEmployeeRecruitment(EmployeeDTO employeeDTO) {
		
		String employeeCode = employeeDTO.getCode();
		
		Employee employee = employeeMappingManager.map(employeeDTO);
		
		if (!CollectionUtils.isEmpty(employee.getFamilies())) {
			employee.getFamilies().forEach(family -> family.setEmployee(employee));
		}
		
		if (employeeDTO.isNewlyCreated()) {
			logger.info("Start new recruitment process ......>>>>");
			employeeCode = EmployeeUtils.generateEmployeeCode();
			employee.setCode(employeeCode);
		} else {
			logger.info("Update existing recruitment information for employeeCode = {} >>>>>>", employeeCode);
			List<Family> families = familyRepository.findByEmployeeId(employeeDTO.getId());
			
			List<Family> deletedFamilies = families.stream()
					.filter(curFamily -> {
						if (!CollectionUtils.isEmpty(employee.getFamilies())) {
							return !employee.getFamilies()
										.stream()
										.filter(subFamily -> curFamily.getId() == subFamily.getId())
										.findFirst()
										.isPresent();
						} else {
							return true;
						}
					}).collect(Collectors.toList());
			if (!CollectionUtils.isEmpty(deletedFamilies)) {
				logger.info("Deleting the families which aren't in the current submission list");
				familyRepository.deleteAll(deletedFamilies);
			}
		}
		
		employeeRepository.save(employee);
		
		if (employeeDTO.isNewlyCreated()) {
			Map<String, Object> variables = new HashMap<>();
			variables.put("user", "user");
			variables.put("subStatus", "NEW");
			variables.put("existingPosition", false);
		    ProcessInstanceWithVariables instance = processEngine.getRuntimeService().
		    		createProcessInstanceByKey(ProcessDefinitionKeys.EmployeeKeys.RECRUITMENT)
			        .setVariables(variables)
			        .businessKey(employeeCode)
			        .executeWithVariablesInReturn();
		    
		    logger.info("Created Recruitement Process with businessKey={}, processIntanceId={}",
		    		instance.getBusinessKey(), 
		    		instance.getProcessInstanceId());
		}
		
		
		return employeeMappingManager.map(employee);
	}
	
	@Override
	@Transactional
	public void approveEmployeeByLaborStaff(LaborStaffApprovalDTO laborStaffApprovalDTO) {
		long recruitmentUserTaskId = laborStaffApprovalDTO.getRecruitmentUserTaskId();
		RecruitmentUserTask recruitmentUserTask = recruitmentUserTaskRepository.findById(recruitmentUserTaskId)
				.orElseThrow(() -> new IllegalArgumentException("RecuitmentUserTask = " + recruitmentUserTaskId + " not existing!!!"));
		
		String taskId = recruitmentUserTask.getTaskId();
		
		ApprovalDetail approvalDetail = ApprovalDetail.builder()
				.employeeId(laborStaffApprovalDTO.getEmployeeId())
				.taskId(taskId)
				.type(RecruitmentApprovalDetailType.LABOR_STAFF)
				.action(laborStaffApprovalDTO.getAction())
				.commentCode(laborStaffApprovalDTO.getCommentCode())
				.commentTitle(laborStaffApprovalDTO.getCommentTitle())
				.commentDetail(laborStaffApprovalDTO.getCommentDetail())
				.build();
		approvalDetailRepository.save(approvalDetail);
		
		Map<String, Object> assigneeVariables = new HashMap<>();
		assigneeVariables.put("action", laborStaffApprovalDTO.getAction());
		assigneeVariables.put("directManager", "manager1");
	    taskService.complete(taskId, assigneeVariables);
	}

	@Override
	@Transactional
	public void approveEmployeeByDirectManager(DirectManagerApprovalDTO directManagerApprovalDTO) {
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
	public void approveEmployeeBySeniorManager(SeniorDirectManagerApprovalDTO seniorDirectManagerApprovalDTO) {
		long recruitmentUserTaskId = seniorDirectManagerApprovalDTO.getRecruitmentUserTaskId();
		RecruitmentUserTask recruitmentUserTask = recruitmentUserTaskRepository.findById(recruitmentUserTaskId)
				.orElseThrow(() -> new IllegalArgumentException("RecuitmentUserTask = " + recruitmentUserTaskId + " not existing!!!"));
		
		String taskId = recruitmentUserTask.getTaskId();
		String action = seniorDirectManagerApprovalDTO.getAction();
		
		ApprovalDetail approvalDetail = ApprovalDetail.builder()
				.employeeId(seniorDirectManagerApprovalDTO.getEmployeeId())
				.taskId(taskId)
				.type(RecruitmentApprovalDetailType.SENIOR_DIRECT_MANAGER)
				.action(action)
				.commentCode(seniorDirectManagerApprovalDTO.getCommentCode())
				.commentTitle(seniorDirectManagerApprovalDTO.getCommentTitle())
				.commentDetail(seniorDirectManagerApprovalDTO.getCommentDetail())
				.build();
		approvalDetailRepository.save(approvalDetail);
		
		Map<String, Object> assigneeVariables = new HashMap<>();
		assigneeVariables.put("action", seniorDirectManagerApprovalDTO.getAction());
	    taskService.complete(taskId, assigneeVariables);
	}




}