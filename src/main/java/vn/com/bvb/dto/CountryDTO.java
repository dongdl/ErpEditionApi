package vn.com.bvb.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
public class CountryDTO extends BaseEntityDTO {
	private long id;
	private String code; // Mã quốc gia
	private String name; // Tên quốc gia
	private String description;
}
