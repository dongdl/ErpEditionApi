package vn.com.bvb.mapper;

import org.mapstruct.Mapper;

import vn.com.bvb.dto.EmployeeDTO;
import vn.com.bvb.entity.Employee;

@Mapper(componentModel = "spring")
public interface EmployeeMappingManager {
	
	EmployeeDTO map(Employee employee);
	
	Employee map(EmployeeDTO employeeDTO);


}
