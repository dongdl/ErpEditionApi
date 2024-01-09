package vn.com.bvb.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import vn.com.bvb.dto.BaseEntityDTO;

// https://loda.me/articles/jpahuong-dan-onetomany-va-manytoone
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@Entity(name = "employee")
public class Employee extends BaseEntityDTO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "code")
	private int code; // Mã nhân sự (Auto generator) Tương đương với code bên recruitmentUserTask
	@Column(name = "fullName")
	private String fullName; // Họ và tên"
	@Column(name = "positionCode")
	private String positionCode; // Mã chức danh, tên chức danh"
	@Column(name = "level")
	private int level; // Cấp bậc"
	@Column(name = "departmentCode")
	private String departmentCode; // Mã đơn vị, tên đơn vị, Mã trung tâm tên trung tâm"
	@Column(name = "zone")
	private String zone; // Vùng (vùng 1, vùng 2…)"
	@Column(name = "region")
	private String region; // Miền (miền bắc, trung, nam)"
	@Column(name = "taxCode")
	private String taxCode; // Mã số thuế thu nhập cá nhân"
	@Column(name = "insuranceNumber")
	private String insuranceNumber; // Số sổ bảo hiểm"
	@Column(name = "accountNum")
	private String accountNum; // Số TK BVB"
	@Column(name = "status")
	private String status; /*
							 * Trạng thái: =1: Cộng tác viên =2: Học việc =3: Thử việc =4: Chính thức =5:
							 * Nghỉ việc =6: Nghỉ không lương =7: Tạm nghỉ, Hoãn hợp đồng =99: Chưa phân
							 * loại
							 */

	@Column(name = "photo")
	private String photo; // Ảnh thẻ"
	@Column(name = "birthday")
	private Date birthday; // Ngày sinh"
	@Column(name = "gender")
	private int gender; // Giới tính"
	@Column(name = "addressCode")
	private String addressCode; // Nơi sinh"
	@Column(name = "addressEx")
	private String addressEx; // Xóm phố, số nhà…"
	@Column(name = "ethnicCode")
	private String ethnicCode; // Dân tộc"
	@Column(name = "isParty ")
	private Boolean isParty; // Là đảng viên"
	@Column(name = "partyDate")
	private Date partyDate; // Ngày vào đảng"
	@Column(name = "partyPosition")
	private String partyPosition; // Chức vụ"
	@Column(name = "partyAddress")
	private String partyAddress; // Nơi vào đảng"
	@Column(name = "isArmy")
	private Boolean isArmy; // Quân đội"
	@Column(name = "isVeterans")
	private Boolean isVeterans; // Thương binh"
	@Column(name = "isMartyrsChild")
	private Boolean isMartyrsChild; // Con liệt sỹ"
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
	@Column(name = "maritalStatus")
	private String maritalStatus; // Tình trạng hôn nhân (Độc thân/Có gđ/…)"
	@Column(name = "contactAddress")
	private String contactAddress; // Thông tin liên hệ khi cần"
	@Column(name = "contactPhone")
	private String contactPhone; // Số điện thoại liên hệ khi cần"
	@Column(name = "probationaryDontractDate")
	private Date probationaryDontractDate; // Ngày vào ngân hàng (Ngày quyết định tuyển dụng đầu tiên)"
	@Column(name = "officialContractDate")
	private Date officialContractDate; // Ngày hợp đồng chính thức"
	@Column(name = "positionDate")
	private Date positionDate; // Ngày bổ nhiệm chức danh hiện tại."
	@Column(name = "education")
	private String education; // Trình độ học vấn"
	@Column(name = "foreignLanguage")
	private String foreignLanguage; // Trình độ ngoại ngữ"
	@Column(name = "nationalityCode")
	private String nationalityCode; // Quốc tịch"
	@Column(name = "description")
	private String description; 

	@Column(name = "recruitmentSource")
	private String recruitmentSource; // Nguồn tuyển dụng"
	@Column(name = "interviewDate")
	private Date interviewDate; // Ngày phỏng vấn"
	@Column(name = "recruitmentMinutes")
	private String recruitmentMinutes; // Biên bản tuyển dụng số"
	@Column(name = "recruitmentProposal")
	private String recruitmentProposal; // Đề nghị tuyển dụng số"
	@Column(name = "referName")
	private String referName; // Thông tin tham khảo - Họ tên"
	@Column(name = "referPosition")
	private String referPosition; // Thông tin tham khảo - Chức vụ"
	@Column(name = "referWorkUnit")
	private String referWorkUnit; // Thông tin tham khảo - Đơn vị công tác"
	@Column(name = "referRelationShip")
	private String referRelationShip; // Thông tin tham khảo - Mối quan hệ"
	@Column(name = "referMobile")
	private String referMobile; // Thông tin tham khảo - Mobile"
	@Column(name = "referEmail")
	private String referEmail; // Thông tin tham khảo - Email"
	@Column(name = "referDescription")
	private String referDescription; // Thông tin tham khảo - Ghi chú thêm"
	@Column(name = "referOrganName")
	private String referOrganName; // Người thân bạn bè BVB - Họ tên"
	@Column(name = "referOrganPosition")
	private String referOrganPosition; // Người thân bạn bè BVB - Chức vụ"
	@Column(name = "referOrganWorkUnit")
	private String referOrganWorkUnit; // Người thân bạn bè BVB - Đơn vị công tác"
	@Column(name = "referOrganRelationShip")
	private String referOrganRelationShip; // Người thân bạn bè BVB - Mối quan hệ"
	@Column(name = "referOrganMobile")
	private String referOrganMobile; // Người thân bạn bè BVB - Mobile"
	@Column(name = "referOrganEmail")
	private String referOrganEmail; // Người thân bạn bè BVB - Email"
	@Column(name = "referOrganDescription")
	private String referOrganDescription; // Người thân bạn bè BVB - Ghi chú thêm"
	@Column(name = "referOtherLocation")
	private String referOtherLocation; // Thông tin tham khảo khác - Vị trí"
	@Column(name = "referOtherDate")
	private String referOtherDate; // Thông tin tham khảo khác - Thời gian"

	@Column(name = "contractRealDate")
	private Date contractRealDate; // Thông tin HĐLĐ ban đầu - Ngày vào thực tế"
	@Column(name = "contractRealShortDate")
	private String contractRealShortDate; // Thông tin HĐLĐ ban đầu - Tháng/Năm"
	@Column(name = "contractType")
	private int contractType; // Thông tin HĐLĐ ban đầu - Loại hợp đồng (=1:Học việc;=2:thử việc;=3:chính
								// thức;=99:Other)"
	@Column(name = "contractDurationDate")
	private Date contractDurationDate; // Thông tin HĐLĐ ban đầu - Thời hạn hợp đồng"
	@Column(name = "contractBeginDate")
	private Date contractBeginDate; // Thông tin HĐLĐ ban đầu - HĐLĐ: Ngày bắt đầu"
	@Column(name = "contractEndDate")
	private Date contractEndDate; // Thông tin HĐLĐ ban đầu - HĐLĐ: Ngày kết thúc"

	@Column(name = "salaryApprentice")
	private Double salaryApprentice; // Thông tin thu nhập - Lương học việc"
	@Column(name = "salaryProbation")
	private Double salaryProbation; // Thông tin thu nhập - Lương thử việc"
	@Column(name = "salaryOfficial")
	private Double salaryOfficial; // Thông tin thu nhập - Lương chính thức"
	@Column(name = "salaryOfficialDate")
	private Date salaryOfficialDate; // Thông tin thu nhập - Ngày chính thức"
	@Column(name = "salaryInsurance")
	private Double salaryInsurance; // Thông tin thu nhập - LCB tham gia bảo hiểm"
	@Column(name = "salaryAllowance1")
	private Double salaryAllowance1; // Thông tin thu nhập - Phụ cấp 1"
	@Column(name = "salaryAllowance2")
	private Double salaryAllowance2; // Thông tin thu nhập - Phụ cấp 2"
	
	@OneToMany(mappedBy = "employee", cascade = CascadeType.ALL) // Quan hệ 1-n với đối tượng ở dưới (Family) (1 người có nhiều con hoặc người thân)
    // mappedBy trỏ tới tên biến Employee ở trong Family.
    @EqualsAndHashCode.Exclude // không sử dụng trường này trong equals và hashcode
    @ToString.Exclude // Không sử dụng trong toString()
	private List<Family> families;

}
