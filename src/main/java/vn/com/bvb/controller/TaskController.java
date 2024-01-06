package vn.com.bvb.controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.ProcessEngines;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.camunda.bpm.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;

import vn.com.bvb.dto.CompleteCurrentTaskDTO;
import vn.com.bvb.dto.CompleteCurrentTaskResultDTO;

@Path("/custom-task")
public class TaskController {

	@Autowired
	private RuntimeService runtimeService;

	@POST
	@Path(value = "/complete-current-task")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public CompleteCurrentTaskResultDTO completeCurrentTask(CompleteCurrentTaskDTO completeCurrentTaskDTO) {
		List<ProcessInstance> processInstances = runtimeService.createProcessInstanceQuery()
				.processInstanceBusinessKey(completeCurrentTaskDTO.getBusinessKey()).list(); 

		if ( processInstances != null && !processInstances.isEmpty() ) {
			ProcessInstance processInstance = null;
			if ( processInstances.size() > 1 ) {
				processInstance = processInstances.stream()
						.filter(pi -> pi.getProcessDefinitionId().startsWith("two_eyes_approval"))
						.findFirst()
						.orElseThrow(IndexOutOfBoundsException::new);
			} else {
				processInstance = processInstances.get(0);
			}
			
			ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
			
			Task task = processEngine.getTaskService().createTaskQuery()
					.active()
					.processInstanceId(processInstance.getId())
					.singleResult();
			
			processEngine.getTaskService().complete(task.getId());
			
			return new CompleteCurrentTaskResultDTO(completeCurrentTaskDTO.getBusinessKey(),
					processInstance.getProcessDefinitionId(),
					task.getName(), 
					task.getId());
		}
		
		return new CompleteCurrentTaskResultDTO(completeCurrentTaskDTO.getBusinessKey(),null, null, null);
	}
}
