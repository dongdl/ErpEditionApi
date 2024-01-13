package vn.com.bvb.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
public class WardComuneDTO extends BaseEntityDTO {
	private long id;
	private String code; // Mã phường xã
	private String name; // Tên phường xã
	private String levelName; // Cấp (Phường/xã)
	private String districtCode; // Mã quận/huyện
	private String provinceCode; // Mã tỉnh/TP
	private String countryCode; // Mã nước
	private String description; // 

}
