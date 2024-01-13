package vn.com.bvb.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
public class EmployeeAttachmentDTO extends BaseEntityDTO {
	private long id;

	private String fileId; // Id file
	private String folder; // Thư mục lưu trữ file
	private String fileName; // Tên file
	private String fileType; // Loại file
	private Double fileSize; // Dung lượng file
	private String description; // 
}
