package vn.com.bvb.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@Entity(name = "ethnic") // Dân tộc
@EntityListeners(AuditingEntityListener.class)
public class Ethnic extends BaseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name = "code")
	private String code; // " Mã dân tộc
	@Column(name = "name")
	private String name; // " Tên
	@Column(name = "otherName")
	private String otherName; // " Tên khác
	@Column(name = "description")
	private String description; // "

}
