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
public class DirectManagerApprovalDTO {
	
	private long recruitmentUserTaskId;;

	private String action;
	
	private String commentCode;
	
	private String commentTitle;
	
	private String commentDetail;
	

}
