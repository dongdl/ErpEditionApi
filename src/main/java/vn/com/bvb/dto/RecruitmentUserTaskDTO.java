package vn.com.bvb.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
public class RecruitmentUserTaskDTO extends EmployeeDTO {
	
	private long recruitmentUserTaskId;
	
	private String assignee;
	
	private String status;

}
