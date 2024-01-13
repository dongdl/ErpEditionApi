package vn.com.bvb.camunda.listener.complete;

import java.util.List;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.ExecutionListener;
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
public class DoneRecruitmentListener  implements ExecutionListener {
	
	private final Logger logger = LoggerFactory.getLogger(getClass());

	private RecruitmentUserTaskRepository recruitmentUserTaskRepository;
	
	private EmployeeRepository employeeRepository;
	
	@Override
	@Transactional
	public void notify(DelegateExecution execution) {
		String processInstanceId = execution.getProcessInstanceId();
		String businessKey = execution.getProcessInstance().getBusinessKey();

		logger.info("processInstanceId = {}, businessKey = {}", 
				processInstanceId, businessKey);
		
		Employee employee = employeeRepository.findByCode(businessKey)
				.orElseThrow(() -> new NullPointerException("Not Found Employee with code=" + businessKey));

		List<RecruitmentUserTask> recruitmentUserTasks = recruitmentUserTaskRepository
				.findByEmployeeId(employee.getId());
		recruitmentUserTasks.forEach(recruitmentUserTask -> recruitmentUserTask.setStatus(ApprovalStatus.APPROVED.getStatus()));
		recruitmentUserTaskRepository.saveAll(recruitmentUserTasks);
		
	}

}
