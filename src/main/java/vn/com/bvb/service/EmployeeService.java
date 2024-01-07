package vn.com.bvb.service;

import org.springframework.stereotype.Service;

import vn.com.bvb.dto.EmployeeDTO;

@Service
public interface EmployeeService {

	public EmployeeDTO findByCode(String code);
	EmployeeDTO recruitEmployee(EmployeeDTO employeeDTO);

}
