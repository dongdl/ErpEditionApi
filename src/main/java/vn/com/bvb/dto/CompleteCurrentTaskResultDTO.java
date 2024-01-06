package vn.com.bvb.dto;

public class CompleteCurrentTaskResultDTO {

	private String businessKey;
	private String processDefinitionKey;
	private String taskName;
	private String taskId;
	
	public CompleteCurrentTaskResultDTO(String businessKey, String processDefinitionKey, String taskName,
			String taskId) {
		super();
		this.businessKey = businessKey;
		this.processDefinitionKey = processDefinitionKey;
		this.taskName = taskName;
		this.taskId = taskId;
	}

	public CompleteCurrentTaskResultDTO() {
		super();
	}

	public String getBusinessKey() {
		return businessKey;
	}

	public void setBusinessKey(String businessKey) {
		this.businessKey = businessKey;
	}

	public String getProcessDefinitionKey() {
		return processDefinitionKey;
	}

	public void setProcessDefinitionKey(String processDefinitionKey) {
		this.processDefinitionKey = processDefinitionKey;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public String getTaskId() {
		return taskId;
	}

	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}

}
