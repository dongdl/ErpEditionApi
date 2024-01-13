package vn.com.bvb.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
public class ProvinceDTO extends BaseEntityDTO {
	private long id;
	private String code; // Mã tỉnh/TP
	private String name; // Tên tỉnh/TP
	private String levelName; // Cấp (Tỉnh/TP)
	private String countryCode; // Mã nước

}
