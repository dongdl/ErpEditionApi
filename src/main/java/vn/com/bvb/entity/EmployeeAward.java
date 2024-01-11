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
@Entity(name = "employeeAward")
public class EmployeeAward extends BaseEntityDTO {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "awards")
	private String awards; // Danh hiệu"
	@Column(name = "awardDate")
	private Date awardDate; // Ngày trao giải"
	@Column(name = "description")
	private String description;

	// Many to One Có nhiều thành viên trong một gia đình.
	@ManyToOne
	@JoinColumn(name = "employeeId") // thông qua khóa ngoại employeeId
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	private Employee employee;
}
