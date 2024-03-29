package vn.com.bvb.camunda.listener.create;

import java.util.Optional;

import org.camunda.bpm.engine.delegate.DelegateTask;
import org.camunda.bpm.engine.delegate.TaskListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import lombok.AllArgsConstructor;
import vn.com.bvb.constants.ApprovalStatus;
import vn.com.bvb.entity.ApprovalHistory;
import vn.com.bvb.entity.Employee;
import vn.com.bvb.entity.RecruitmentUserTask;
import vn.com.bvb.repository.ApprovalHistoryRepository;
import vn.com.bvb.repository.EmployeeRepository;
import vn.com.bvb.repository.RecruitmentUserTaskRepository;

@Component
@AllArgsConstructor
public class SeniorDirectManagerListener implements TaskListener {

	private final Logger logger = LoggerFactory.getLogger(getClass());

	private RecruitmentUserTaskRepository recruitmentUserTaskRepository;
	
	private EmployeeRepository employeeRepository;
	
	private ApprovalHistoryRepository approvalHistoryRepository;

	@Override
	@Transactional
	public void notify(DelegateTask delegateTask) {
		String processInstanceId = delegateTask.getProcessInstanceId();
		String businessKey = delegateTask.getExecution().getProcessInstance().getBusinessKey();
		String assignee = delegateTask.getAssignee();

		logger.info("processInstanceId = {}, businessKey = {}, assignee = {}", 
				processInstanceId, businessKey, assignee);
		
		Employee employee = employeeRepository.findByCode(businessKey)
				.orElseThrow(() -> new NullPointerException("Not Found Employee with code=" + businessKey));


		Optional<RecruitmentUserTask> recruitmentUserTaskOptional = recruitmentUserTaskRepository
				.findByEmployeeIdAndAssignee(employee.getId(), assignee);
		if (recruitmentUserTaskOptional.isPresent()) {
			logger.info("Update PROCESSING task ------> WAIT_PROCESSING task");
			RecruitmentUserTask recruitmentUserTask = recruitmentUserTaskOptional.get();
			recruitmentUserTask.setTaskId(delegateTask.getId());
			recruitmentUserTask.setStatus(ApprovalStatus.WAIT_PROCESSING.getStatus());
			recruitmentUserTaskRepository.save(recruitmentUserTask);
		} else {
			logger.info("Creating UserTask for 'Cán bộ quản lý trên 1 cấp");
			RecruitmentUserTask recruitmentUserTask = RecruitmentUserTask.builder()
					.employeeId(employee.getId())
					.assignee(assignee)
					.taskId(delegateTask.getId())
					.status(ApprovalStatus.WAIT_PROCESSING.getStatus())
					.build();
			recruitmentUserTaskRepository.save(recruitmentUserTask);
		}
		
		ApprovalHistory approvalHistory = ApprovalHistory.builder()
				.employeeId(employee.getId())
				.taskId(delegateTask.getId())
				.taskName(delegateTask.getName())
				.assignee(assignee)
				.build();
		approvalHistoryRepository.save(approvalHistory);
	}

}
