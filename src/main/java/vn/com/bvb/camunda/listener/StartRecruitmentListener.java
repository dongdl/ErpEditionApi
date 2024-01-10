package vn.com.bvb.camunda.listener;

import java.util.Date;

import org.camunda.bpm.engine.delegate.DelegateTask;
import org.camunda.bpm.engine.delegate.TaskListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import vn.com.bvb.entity.Employee;
import vn.com.bvb.entity.RecruitmentUserTask;
import vn.com.bvb.repository.EmployeeRepository;
import vn.com.bvb.repository.RecruitmentUserTaskRepository;

@Component
@AllArgsConstructor
public class StartRecruitmentListener implements TaskListener {

	private final Logger logger = LoggerFactory.getLogger(getClass());

	private RecruitmentUserTaskRepository recruitmentUserTaskRepository;
	
	private EmployeeRepository employeeRepository;

	@Override
	public void notify(DelegateTask delegateTask) {
		String processInstanceId = delegateTask.getProcessInstanceId();
		String businessKey = delegateTask.getExecution().getProcessInstance().getBusinessKey();

		logger.info("processInstanceId = {}, businessKey = {}", processInstanceId, businessKey);
		
		Employee employee = employeeRepository.findByCode(businessKey)
				.orElseThrow(() -> new NullPointerException("Not Found Employee with code=" + businessKey));

		RecruitmentUserTask recruitmentUserTask = RecruitmentUserTask.builder()
				.code(employee.getCode())
				.fullName(employee.getFullName())
				.email(employee.getEmail())
				.positionCode(employee.getPositionCode())
				.positionDate(new Date())
				.departmentCode(employee.getDepartmentCode())
				.zone(employee.getZone())
				.region(employee.getRegion())
				.status(employee.getStatus())
				.gender(employee.getGender())
				.assignee("demo").build();
		
		logger.info("Creating UserTask for 'Cán bộ tuyển dụng'");
		recruitmentUserTaskRepository.save(recruitmentUserTask);
	}

}
