package vn.com.bvb.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import vn.com.bvb.dto.DirectManagerApprovalDTO;
import vn.com.bvb.dto.EmployeeDTO;
import vn.com.bvb.dto.LaborStaffApprovalDTO;
import vn.com.bvb.dto.SeniorDirectManagerApprovalDTO;
import vn.com.bvb.service.EmployeeService;

@Path("/hrm/employee")
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;

	@GET
	@Path(value = "/find/{code}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public EmployeeDTO findByCode(@PathParam("code") String code) {
		return employeeService.findByCode(code);
	}
	
	
	@POST
	@Path(value = "/create")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public EmployeeDTO startEmployeeRecruitment(EmployeeDTO employeeDTO) {
		return employeeService.startEmployeeRecruitment(employeeDTO);
	}
	
	@POST
	@Path(value = "/labor-staff/approval")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void approveEmployee(LaborStaffApprovalDTO laborStaffApprovalDTO) {
		employeeService.approveEmployeeByLaborStaff(laborStaffApprovalDTO);
	}
	
	@POST
	@Path(value = "/direct-manager/approval")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void approveEmployeeByDirectManager(DirectManagerApprovalDTO directManagerApprovalDTO) {
		employeeService.approveEmployeeByDirectManager(directManagerApprovalDTO);
	}
	
	@POST
	@Path(value = "/senior-direct-manager/approval")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void approveEmployeeBySeniorManager(SeniorDirectManagerApprovalDTO seniorDirectManagerApprovalDTO) {
		employeeService.approveEmployeeBySeniorManager(seniorDirectManagerApprovalDTO);
	}
	
	
}
