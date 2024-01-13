package vn.com.bvb.mapper;

import org.mapstruct.Mapper;

import vn.com.bvb.dto.EmployeeDTO;
import vn.com.bvb.entity.Employee;

@Mapper(componentModel = "spring")
public abstract class EmployeeMappingManager {
	
	public abstract EmployeeDTO map(Employee employee);
	
	public abstract Employee map(EmployeeDTO employeeDTO);

}
