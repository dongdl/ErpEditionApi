package vn.com.bvb.dto;

import java.util.Date;


import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
public class FamilyDTO {
	private long id;

	private String relationShip; // Quan hệ"
	private String name; // Họ tên"
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
