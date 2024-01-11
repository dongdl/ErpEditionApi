package vn.com.bvb.camunda.listener;

import java.util.List;

import org.camunda.bpm.engine.delegate.DelegateTask;
import org.camunda.bpm.engine.delegate.TaskListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import vn.com.bvb.constants.ApprovalStatus;
import vn.com.bvb.entity.Employee;
import vn.com.bvb.entity.RecruitmentUserTask;
import vn.com.bvb.repository.EmployeeRepository;
import vn.com.bvb.repository.RecruitmentUserTaskRepository;

@Component
@AllArgsConstructor
public class DirectManagerListener implements TaskListener {

	private final Logger logger = LoggerFactory.getLogger(getClass());

	private RecruitmentUserTaskRepository recruitmentUserTaskRepository;
	
	private EmployeeRepository employeeRepository;

	@Override
	public void notify(DelegateTask delegateTask) {
		String processInstanceId = delegateTask.getProcessInstanceId();
		String businessKey = delegateTask.getExecution().getProcessInstance().getBusinessKey();
		String assignee = delegateTask.getAssignee();

		logger.info("processInstanceId = {}, businessKey = {}, assignee = {}", 
				processInstanceId, businessKey, assignee);
		
		logger.info("Update WAIT_PROCESSING task ------_> PROCESSING task");
		List<RecruitmentUserTask> recruitmentUserTasks = recruitmentUserTaskRepository
				.findByStatus(ApprovalStatus.WAIT_PROCESSING.getStatus());
		recruitmentUserTasks.forEach(recruitmentUserTask -> recruitmentUserTask.setStatus(ApprovalStatus.PROCESSING.getStatus()));
		recruitmentUserTaskRepository.saveAll(recruitmentUserTasks);
		
		Employee employee = employeeRepository.findByCode(businessKey)
				.orElseThrow(() -> new NullPointerException("Not Found Employee with code=" + businessKey));
		
		logger.info("Creating UserTask for 'Cán bộ tuyển dụng'");
		RecruitmentUserTask recruitmentUserTask = RecruitmentUserTask.builder()
				.employeeId(employee.getId())
				.assignee(assignee)
				.taskId(delegateTask.getId())
				.status(ApprovalStatus.WAIT_PROCESSING.getStatus())
				.build();
		

		recruitmentUserTaskRepository.save(recruitmentUserTask);
	}

}