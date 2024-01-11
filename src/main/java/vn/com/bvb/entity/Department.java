package vn.com.bvb.entity;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

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
@Entity(name = "department")
public class Department extends BaseEntityDTO {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "code")
	private String code; // Mã phòng ban"
	@Column(name = "parentLevel")
	private int parentLevel; // Vị trí hiển thị bậc 1"
	@Column(name = "level")
	private int level; // Vị trí hiển thị bậc 2"
	@Column(name = "name")
	private String name; // Tên phòng ban"
	@Column(name = "category")
	private String category; // Loại phòng"
	@Column(name = "description")
	private String description; 
	
	@OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	private Collection<Employee> employees;
}
