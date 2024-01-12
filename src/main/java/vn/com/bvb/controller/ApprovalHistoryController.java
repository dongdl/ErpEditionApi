package vn.com.bvb.controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import vn.com.bvb.dto.ApprovalHistoryDTO;
import vn.com.bvb.service.ApprovalHistoryService;

@Path("/hrm/approval-history")
@AllArgsConstructor
@NoArgsConstructor
public class ApprovalHistoryController {
	
	@Autowired
	private ApprovalHistoryService approvalHistoryService;

	@GET
	@Path(value = "/find/{employeeId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<ApprovalHistoryDTO> findByCode(@PathParam("employeeId") long employeeId) {
		return approvalHistoryService.findAll(employeeId);
	}
	
}
