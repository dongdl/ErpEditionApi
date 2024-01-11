package vn.com.bvb.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
public class EmployeeAwardDTO extends BaseEntityDTO {
	private long id;

	private String awards; // Danh hiệu
	private Date awardDate; // Ngày trao giải
	private String description; //

}
