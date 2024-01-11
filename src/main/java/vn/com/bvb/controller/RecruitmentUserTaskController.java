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
import vn.com.bvb.dto.RecruitmentUserTaskDTO;
import vn.com.bvb.service.RecruitmentUserTaskService;

@Path("/usertask/recruitment")
@AllArgsConstructor
@NoArgsConstructor
public class RecruitmentUserTaskController {
	
	@Autowired
	private RecruitmentUserTaskService recruitmentUserTaskService;

	@GET
	@Path(value = "/{assignee}/list")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<RecruitmentUserTaskDTO> findByCode(@PathParam("assignee") String assignee) {
		return recruitmentUserTaskService.findByAssignee(assignee);
	}
	
	@GET
	@Path(value = "/{assignee}/list/{status}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<RecruitmentUserTaskDTO> findByAssigneeAndStatus(@PathParam("assignee") String assignee,
			@PathParam("status") String status) {
		return recruitmentUserTaskService.findByAssigneeAndStatus(assignee);
	}
}
