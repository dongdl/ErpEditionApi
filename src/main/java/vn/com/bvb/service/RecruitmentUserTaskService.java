package vn.com.bvb.service;

import java.util.List;

import org.springframework.stereotype.Service;

import vn.com.bvb.dto.RecruitmentUserTaskDTO;

@Service
public interface RecruitmentUserTaskService {

	List<RecruitmentUserTaskDTO> findByAssignee(String assignee);

}
