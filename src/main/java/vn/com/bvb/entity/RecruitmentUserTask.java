package vn.com.bvb.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@Entity(name = "recruitment_user_task")
public class RecruitmentUserTask {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "code")
	private String code;
	
	@Column(name = "full_name")
	private String fullName;

	@Column(name = "email")
	private String email;

	@Column(name = "position_code")
	private String positionCode;

	@Column(name = "position_date")
	private Date positionDate;

	@Column(name = "department_code")
	private String departmentCode;

	@Column(name = "zone")
	private String zone;

	@Column(name = "region")
	private String region;

	@Column(name = "status")
	private String status;

	@Column(name = "gender")
	private Integer gender;
	
	
	
	@Column(name = "assignee")
	private String assignee;

}
