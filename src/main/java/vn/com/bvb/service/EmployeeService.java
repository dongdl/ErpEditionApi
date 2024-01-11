package vn.com.bvb.service;

import org.springframework.stereotype.Service;

import vn.com.bvb.dto.DirectManagerApprovalDTO;
import vn.com.bvb.dto.EmployeeDTO;
import vn.com.bvb.dto.SeniorDirectManagerApprovalDTO;

@Service
public interface EmployeeService {

	public EmployeeDTO findByCode(String code);
	
	EmployeeDTO recruitEmployee(EmployeeDTO employeeDTO);
	
	void approveEmployee(DirectManagerApprovalDTO directManagerApprovalDTO);
	
	void approveEmployee(SeniorDirectManagerApprovalDTO directManagerApprovalDTO);
	
}
