package vn.com.bvb.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
public class DistrictDTO extends BaseEntityDTO {
	private long id;
	private String code; // Mã quận/huyện
	private String name; // Tên quận huyện
	private String levelName; // Cấp (Quận/Huyện)
	private String provinceCode; // Mã tỉnh/TP
	private String countryCode; // Mã nước
	private String description; //

}
