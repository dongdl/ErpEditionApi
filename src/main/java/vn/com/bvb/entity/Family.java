package vn.com.bvb.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import vn.com.bvb.dto.BaseEntityDTO;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@Entity(name = "family")
public class Family extends BaseEntityDTO {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "relationShip")
	private String relationShip; // Quan hệ"
	@Column(name = "name")
	private String name; // Họ tên"
	@Column(name = "birthday")
	private Date birthday; // Ngày sinh"
	@Column(name = "gender")
	private int gender; // Giới tính"
	@Column(name = "job")
	private String job; // Nghề nghiệp"
	@Column(name = "workUnit")
	private String workUnit; // Nơi công tác/làm việc"
	@Column(name = "permanentAddress")
	private String permanentAddress; // Hộ khẩu thường trú"
	@Column(name = "currentAddress")
	private String currentAddress; // Nơi ở hiện tại"
	@Column(name = "cardId")
	private String cardId; // Số CMT/Thẻ căn cước"
	@Column(name = "cardDate")
	private String cardDate; // Ngày cấp Số CMT/Thẻ căn cước"
	@Column(name = "cardAddress")
	private String cardAddress; // Nơi cấp Số CMT/Thẻ căn cước"
	@Column(name = "passportNumber")
	private String passportNumber; // Số sổ hộ chiếu"
	@Column(name = "passportDate")
	private String passportDate; // Ngày cấp hộ chiếu"
	@Column(name = "passportExpiredDate")
	private String passportExpiredDate; // Ngày hết hạn hộ chiếu"
	@Column(name = "homePhone")
	private String homePhone; // Điện thoại nhà riêng"
	@Column(name = "mobilePhone")
	private String mobilePhone; // Điện thoại di động"
	@Column(name = "email")
	private String email; // Email BVB"
	@Column(name = "emailPrivate")
	private String emailPrivate; // Email cá nhân"
	@Column(name = "description")
	private String description; 
	
	// Many to One Có nhiều thành viên trong một gia đình.
    @ManyToOne
    @JoinColumn(name="employeeId") // thông qua khóa ngoại employeeId
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Employee employee;
}
