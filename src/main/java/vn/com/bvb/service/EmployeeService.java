package vn.com.bvb.service;

import org.springframework.stereotype.Service;

import vn.com.bvb.entity.Employee;

@Service
public interface EmployeeService {

	public Employee findByCode(String code);

}
