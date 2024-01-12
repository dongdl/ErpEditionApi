package vn.com.bvb.entity;

import vn.com.bvb.dto.BaseEntityDTO;

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
@Entity(name = "province")
public class Province extends BaseEntityDTO {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name = "code")
	private String code; // Mã tỉnh/TP"
	@Column(name = "name")
	private String name; // Tên tỉnh/TP"
	@Column(name = "levelName")
	private String levelName; // Cấp (Tỉnh/TP)"
	@Column(name = "countryCode")
	private String countryCode; // Mã nước"
	@Column(name = "description")
	private String description; // "

}