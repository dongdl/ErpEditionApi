package vn.com.bvb.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import vn.com.bvb.entity.RecruitmentUserTask;

public interface RecruitmentUserTaskRepository extends CrudRepository<RecruitmentUserTask, Long> {

	List<RecruitmentUserTask> findByAssignee(String assignee);
	
	List<RecruitmentUserTask> findByEmployeeIdAndStatus(long employeeId, String status);
	
	List<RecruitmentUserTask> findByAssigneeAndStatus(String assignee, String status);



}
