package vn.com.bvb.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import vn.com.bvb.dto.RecruitmentUserTaskDTO;
import vn.com.bvb.entity.Employee;
import vn.com.bvb.entity.RecruitmentUserTask;
import vn.com.bvb.mapper.RecruitmentUserTaskMappingManager;
import vn.com.bvb.repository.EmployeeRepository;
import vn.com.bvb.repository.RecruitmentUserTaskRepository;
import vn.com.bvb.service.RecruitmentUserTaskService;

@Service
@AllArgsConstructor
public class RecruitmentUserTaskServiceImpl implements RecruitmentUserTaskService {

	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	private EmployeeRepository employeeRepository;
	
	private RecruitmentUserTaskRepository recruitmentUserTaskRepository;
	
	private RecruitmentUserTaskMappingManager recruitmentUserTaskMappingManager;

	@Override
	public List<RecruitmentUserTaskDTO> findByAssignee(String assignee) {
		logger.info("Get all recruitment usertasks for assignee={} >>>>>>>", assignee);
		List<RecruitmentUserTask> recruitmentUserTasks = recruitmentUserTaskRepository.findByAssignee(assignee);
		return recruitmentUserTasks.stream()
			.map(recruitmentUserTask -> {
				long employeeId = recruitmentUserTask.getEmployeeId();
				Employee employee = employeeRepository.findById(employeeId)
						.orElseThrow(() -> new NullPointerException("EmployeeId = " + employeeId + " not existing!!!"));
				return recruitmentUserTaskMappingManager.map(employee);
			}).collect(Collectors.toList());
	}

}
