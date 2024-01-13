package vn.com.bvb.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class LaborStaffApprovalDTO {
	
	private long recruitmentUserTaskId;
	
	private long employeeId;

	private String commentCode;
	
	private String commentTitle;
	
	private String commentDetail;
	
}
