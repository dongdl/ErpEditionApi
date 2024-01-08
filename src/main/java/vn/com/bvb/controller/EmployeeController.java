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
import vn.com.bvb.dto.EmployeeDTO;
import vn.com.bvb.service.EmployeeService;

@Path("/employee")
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;

	@GET
	@Path(value = "/{code}")
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
	
}
