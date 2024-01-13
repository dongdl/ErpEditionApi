package vn.com.bvb.camunda.listener.complete;

import java.util.List;

import org.camunda.bpm.engine.delegate.DelegateTask;
import org.camunda.bpm.engine.delegate.TaskListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import lombok.AllArgsConstructor;
import vn.com.bvb.constants.ApprovalStatus;
import vn.com.bvb.entity.Employee;
import vn.com.bvb.entity.RecruitmentUserTask;
import vn.com.bvb.repository.EmployeeRepository;
import vn.com.bvb.repository.RecruitmentUserTaskRepository;

@Component
@AllArgsConstructor
public class DoneRecruitmentListener  implements TaskListener {
	
	private final Logger logger = LoggerFactory.getLogger(getClass());

	private RecruitmentUserTaskRepository recruitmentUserTaskRepository;
	
	private EmployeeRepository employeeRepository;
	
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

		List<RecruitmentUserTask> recruitmentUserTasks = recruitmentUserTaskRepository
				.findByEmployeeId(employee.getId());
		recruitmentUserTasks.forEach(recruitmentUserTask -> recruitmentUserTask.setStatus(ApprovalStatus.APPROVED.getStatus()));
		recruitmentUserTaskRepository.saveAll(recruitmentUserTasks);
		
	}

}
