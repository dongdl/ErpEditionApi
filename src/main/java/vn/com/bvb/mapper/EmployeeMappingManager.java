package vn.com.bvb.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import vn.com.bvb.dto.EmployeeDTO;
import vn.com.bvb.entity.Employee;

@Mapper(componentModel = "spring")
public abstract class EmployeeMappingManager {
	
	public abstract EmployeeDTO map(Employee employee);
	
	public abstract Employee map(EmployeeDTO employeeDTO);
	
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "code", ignore = true)
	public abstract void update(@MappingTarget Employee employee, EmployeeDTO employeeDTO);


}
