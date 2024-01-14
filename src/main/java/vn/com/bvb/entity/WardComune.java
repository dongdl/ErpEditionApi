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
@Entity(name = "wardComune") // Phường - Xã
@EntityListeners(AuditingEntityListener.class)
public class WardComune extends BaseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name = "code")
	private String code; // Mã phường xã"
	@Column(name = "name")
	private String name; // Tên phường xã"
	@Column(name = "levelName")
	private String levelName; // Cấp (Phường/xã)"
	@Column(name = "districtCode")
	private String districtCode; // Mã quận/huyện"
	@Column(name = "provinceCode")
	private String provinceCode; // Mã tỉnh/TP"
	@Column(name = "countryCode")
	private String countryCode; // Mã nước"
	@Column(name = "description")
	private String description; // "

}
