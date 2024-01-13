package vn.com.bvb.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
public class EthnicDTO extends BaseEntityDTO {
	private long id;
	private String code; //
	private String name; //
	private String otherName; //
	private String description; //

}
