package vn.com.bvb.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
public class EmployeeHistoryDTO extends BaseEntityDTO {
	private long id;

	private String content; // Nội dung hàng đợi
	private String status; // Trạng thái hàng đợi
	private String nextStatus; // Trạng thái hàng đợi tiếp theo
	private String description; //

}
