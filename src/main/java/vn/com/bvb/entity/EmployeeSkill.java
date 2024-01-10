package vn.com.bvb.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import vn.com.bvb.dto.BaseEntityDTO;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@Entity(name = "employeeSkill")
public class EmployeeSkill extends BaseEntityDTO {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "code")
	private String code; // Skill: Mã"
	@Column(name = "fromDate")
	private Date fromDate; // Skill: Thời gian"
	@Column(name = "toDate")
	private Date toDate; // Skill: Thời gian"
	@Column(name = "company")
	private String company; // Skill: Đơn vị công tác"
	@Column(name = "department")
	private String department; // Skill: Phòng ban"
	@Column(name = "position")
	private String position; // Skill: Chức danh"
	@Column(name = "salary")
	private Double salary; // Skill: Mức lương"
	@Column(name = "description")
	private String description; // "

	// Many to One Có nhiều thành viên trong một gia đình.
	@ManyToOne
	@JoinColumn(name = "employeeId") // thông qua khóa ngoại employeeId
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	private Employee employee;
}
