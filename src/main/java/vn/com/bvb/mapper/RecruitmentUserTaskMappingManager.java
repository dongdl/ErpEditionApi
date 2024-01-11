package vn.com.bvb.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import vn.com.bvb.dto.EmployeeDTO;
import vn.com.bvb.dto.RecruitmentUserTaskDTO;
import vn.com.bvb.entity.Employee;

@Mapper(componentModel = "spring")
public interface RecruitmentUserTaskMappingManager {
	
	RecruitmentUserTaskDTO map(Employee employee);
	
	List<RecruitmentUserTaskDTO> map(List<EmployeeDTO> employeeDTOs);
	
}
