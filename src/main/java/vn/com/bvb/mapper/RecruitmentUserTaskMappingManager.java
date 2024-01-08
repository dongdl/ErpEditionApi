package vn.com.bvb.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import vn.com.bvb.dto.RecruitmentUserTaskDTO;
import vn.com.bvb.entity.RecruitmentUserTask;

@Mapper(componentModel = "spring")
public interface RecruitmentUserTaskMappingManager {
	
	RecruitmentUserTaskDTO map(RecruitmentUserTask recruitmentUserTask);
	
	List<RecruitmentUserTaskDTO> map(List<RecruitmentUserTask> recruitmentUserTasks);
	
	RecruitmentUserTask map(RecruitmentUserTaskDTO recruitmentUserTaskDTO);


}
