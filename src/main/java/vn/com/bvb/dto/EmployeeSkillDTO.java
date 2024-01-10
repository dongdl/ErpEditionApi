package vn.com.bvb.dto;

import java.util.Date;


import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
public class EmployeeSkillDTO extends BaseEntityDTO {
	private long id;

	private String code; // Skill: Mã
	private Date fromDate; // Skill: Thời gian
	private Date toDate; // Skill: Thời gian
	private String company; // Skill: Đơn vị công tác
	private String department; // Skill: Phòng ban
	private String position; // Skill: Chức danh
	private Double salary; // Skill: Mức lương
	private String description; // 

}
