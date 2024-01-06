package vn.com.bvb.service.impl;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import vn.com.bvb.entity.Employee;
import vn.com.bvb.repository.EmployeeRepository;
import vn.com.bvb.service.EmployeeService;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
	
	private EmployeeRepository employeeRepository;
	
	public Employee findByCode(String code) {
		return employeeRepository.findByCode(code)
				.orElseThrow(() -> new IllegalArgumentException("Employee is not existing with code " + code));
	}

}