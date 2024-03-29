package vn.com.bvb.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
public class ApprovalHistoryDTO extends BaseEntityDTO {
	
	private long id;

	private long employeeId;

	private String taskId;
	
	private String taskName;
	
	private String assignee;
	
	private String commentDetail;
}
