package vn.com.bvb.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
public class DepartmentDTO extends BaseEntityDTO {
	private long id;

	private String code; // Mã phòng ban
	private String name; // Tên phòng ban
	private int parentLevel; // Vị trí hiển thị bậc 1
	private int level; // Vị trí hiển thị bậc 2
	private String category; // Loại phòng
	private String description; 

}
