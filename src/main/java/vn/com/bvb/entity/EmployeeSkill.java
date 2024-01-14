package vn.com.bvb.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@Entity(name = "employeeSkill")
@EntityListeners(AuditingEntityListener.class)
public class EmployeeSkill extends BaseEntity {
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
