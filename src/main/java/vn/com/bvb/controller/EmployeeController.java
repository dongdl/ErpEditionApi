package vn.com.bvb.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import lombok.AllArgsConstructor;
import vn.com.bvb.entity.Employee;
import vn.com.bvb.service.EmployeeService;

@Path("/employee")
@AllArgsConstructor
public class EmployeeController {
	
	private EmployeeService employeeService;

	@GET
	@Path(value = "/{code}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Employee findByCode(@PathParam("code") String code) {
		return employeeService.findByCode(code);
	}
}
