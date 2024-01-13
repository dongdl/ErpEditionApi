package vn.com.bvb.service;

import org.springframework.stereotype.Service;

import vn.com.bvb.dto.DirectManagerApprovalDTO;
import vn.com.bvb.dto.EmployeeDTO;
import vn.com.bvb.dto.LaborStaffApprovalDTO;
import vn.com.bvb.dto.SeniorDirectManagerApprovalDTO;

@Service
public interface EmployeeService {

	EmployeeDTO findByCode(String code);
	
	EmployeeDTO startEmployeeRecruitment(EmployeeDTO employeeDTO);
	
	void approveEmployeeByLaborStaff(LaborStaffApprovalDTO laborStaffApprovalDTO);

	void approveEmployeeByDirectManager(DirectManagerApprovalDTO directManagerApprovalDTO);
	
	void approveEmployeeBySeniorManager(SeniorDirectManagerApprovalDTO directManagerApprovalDTO);
	
}
