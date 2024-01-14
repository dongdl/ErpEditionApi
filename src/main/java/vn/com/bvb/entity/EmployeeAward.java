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
@Entity(name = "employeeAward")
@EntityListeners(AuditingEntityListener.class)
public class EmployeeAward extends BaseEntity {
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
