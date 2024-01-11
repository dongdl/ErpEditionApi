package vn.com.bvb.entity;

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
@Entity(name = "employeeAttachment")
public class EmployeeAttachment extends BaseEntityDTO {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "fileId")
	private String fileId; // Id file"
	@Column(name = "folder")
	private String folder; // Thư mục lưu trữ file"
	@Column(name = "fileName")
	private String fileName; // Tên file"
	@Column(name = "fileType")
	private String fileType; // Loại file"
	@Column(name = "fileSize")
	private Double fileSize; // Dung lượng file"
	@Column(name = "description")
	private String description;

	// Many to One Có nhiều thành viên trong một gia đình.
	@ManyToOne
	@JoinColumn(name = "employeeId") // thông qua khóa ngoại employeeId
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	private Employee employee;
}
