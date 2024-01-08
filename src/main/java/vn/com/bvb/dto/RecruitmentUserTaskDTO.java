package vn.com.bvb.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RecruitmentUserTaskDTO {
	
	private long id;

	private String code;
	
	private String fullName;

	private String email;

	private String positionCode;

	private Date positionDate;

	private String departmentCode;

	private String zone;

	private String region;

	private String status;

	private Integer gender;
	
	
	
	private String assignee;

}
