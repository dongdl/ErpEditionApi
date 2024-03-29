package vn.com.bvb.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
public class FamilyDTO extends BaseEntityDTO {
	private long id;

	private String relationShip; // Quan hệ"
	private String name; // Họ tên"
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	private Date birthday; // Ngày sinh"
	private int gender; // Giới tính"
	private String job; // Nghề nghiệp"
	private String workUnit; // Nơi công tác/làm việc"
	private String permanentAddress; // Hộ khẩu thường trú"
	private String currentAddress; // Nơi ở hiện tại"
	private String cardId; // Số CMT/Thẻ căn cước"
	private String cardDate; // Ngày cấp Số CMT/Thẻ căn cước"
	private String cardAddress; // Nơi cấp Số CMT/Thẻ căn cước"
	private String passportNumber; // Số sổ hộ chiếu"
	private String passportDate; // Ngày cấp hộ chiếu"
	private String passportExpiredDate; // Ngày hết hạn hộ chiếu"
	private String homePhone; // Điện thoại nhà riêng"
	private String mobilePhone; // Điện thoại di động"
	private String email; // Email BVB"
	private String emailPrivate; // Email cá nhân"
	private String description; // "
}
