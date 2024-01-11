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
import vn.com.bvb.dto.SeniorDirectManagerApprovalDTO;
import vn.com.bvb.service.EmployeeService;

@Path("/employee")
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
	public EmployeeDTO recruitEmployee(EmployeeDTO employeeDTO) {
		return employeeService.recruitEmployee(employeeDTO);
	}
	
	@POST
	@Path(value = "/direct-manager/approval")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void approveEmployee(DirectManagerApprovalDTO directManagerApprovalDTO) {
		employeeService.approveEmployee(directManagerApprovalDTO);
	}
	
	@POST
	@Path(value = "/senior-direct-manager/approval")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void approveEmployee(SeniorDirectManagerApprovalDTO seniorDirectManagerApprovalDTO) {
		employeeService.approveEmployee(seniorDirectManagerApprovalDTO);
	}
	
	
}
