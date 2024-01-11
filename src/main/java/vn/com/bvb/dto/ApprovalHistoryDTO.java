package vn.com.bvb.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
public class ApprovalHistoryDTO {
	
	private long id;

	private long employeeId;

	private String taskId;
	
	private String assignee;
}
