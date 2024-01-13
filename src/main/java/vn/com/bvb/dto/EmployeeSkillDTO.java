package vn.com.bvb.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
public class EmployeeSkillDTO extends BaseEntityDTO {
	private long id;

	private String code; // Skill: Mã
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	private Date fromDate; // Skill: Thời gian
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	private Date toDate; // Skill: Thời gian
	private String company; // Skill: Đơn vị công tác
	private String department; // Skill: Phòng ban
	private String position; // Skill: Chức danh
	private Double salary; // Skill: Mức lương
	private String description; // 

}
