package vn.com.bvb.dto;

import java.util.Collection;
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
public class EmployeeDTO extends BaseEntityDTO {

	private long id;

	private String code;

	private String fullName; // Họ và tên
	private String positionCode; // Mã chức danh, tên chức danh
	private int level; // Cấp bậc
	private String departmentCode; // Mã đơn vị, tên đơn vị, Mã trung tâm tên trung tâm
	private String zone; // Vùng (vùng 1, vùng 2…)
	private String region; // Miền (miền bắc, trung, nam)
	private String taxCode; // Mã số thuế thu nhập cá nhân
	private String insuranceNumber; // Số sổ bảo hiểm
	private String accountNum; // Số TK BVB
	/*
	 * Trạng thái: =1: Cộng tác viên =2: Học việc =3: Thử việc =4: Chính thức =5:
	 * Nghỉ việc =6: Nghỉ không lương =7: Tạm nghỉ, Hoãn hợp đồng =99: Chưa phân
	 * loại
	 */
	private String status;

	private String photo; // Ảnh thẻ
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	private Date birthday; // Ngày sinh
	private int gender; // Giới tính
	private String addressCode; // Nơi sinh
	private String addressEx; // Xóm phố, số nhà…
	private String ethnicCode; // Dân tộc
	private Boolean isParty; // Là đảng viên
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	private Date partyDate; // Ngày vào đảng
	
	private String partyPosition; // Chức vụ
	private String partyAddress; // Nơi vào đảng
	private Boolean isArmy; // Quân đội
	private Boolean isVeterans; // Thương binh
	private Boolean isMartyrsChild; // Con liệt sỹ
	private String permanentAddress; // Hộ khẩu thường trú
	private String currentAddress; // Nơi ở hiện tại
	private String cardId; // Số CMT/Thẻ căn cước
	private String cardDate; // Ngày cấp Số CMT/Thẻ căn cước
	private String cardAddress; // Nơi cấp Số CMT/Thẻ căn cước
	private String passportNumber; // Số sổ hộ chiếu
	private String passportDate; // Ngày cấp hộ chiếu
	private String passportExpiredDate; // Ngày hết hạn hộ chiếu
	private String homePhone; // Điện thoại nhà riêng
	private String mobilePhone; // Điện thoại di động
	private String email; // Email BVB
	private String emailPrivate; // Email cá nhân
	private String maritalStatus; // Tình trạng hôn nhân (Độc thân/Có gđ/…)
	private String contactAddress; // Thông tin liên hệ khi cần
	private String contactPhone; // Số điện thoại liên hệ khi cần
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	private Date probationaryDontractDate; // Ngày vào ngân hàng (Ngày quyết định tuyển dụng đầu tiên)
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	private Date officialContractDate; // Ngày hợp đồng chính thức
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	private Date positionDate; // Ngày bổ nhiệm chức danh hiện tại.
	
	private String academicLevel; // Trình độ học vấn
	private String foreignLanguage; // Trình độ ngoại ngữ
	private String nationalityCode; // Quốc tịch
	private String description;

	private String recruitmentSource; // Nguồn tuyển dụng
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	private Date interviewDate; // Ngày phỏng vấn
	
	private String recruitmentMinutes; // Biên bản tuyển dụng số
	private String recruitmentProposal; // Đề nghị tuyển dụng số
	private String referName; // Thông tin tham khảo - Họ tên
	private String referPosition; // Thông tin tham khảo - Chức vụ
	private String referWorkUnit; // Thông tin tham khảo - Đơn vị công tác
	private String referRelationShip; // Thông tin tham khảo - Mối quan hệ
	private String referMobile; // Thông tin tham khảo - Mobile
	private String referEmail; // Thông tin tham khảo - Email
	private String referDescription; // Thông tin tham khảo - Ghi chú thêm
	private String referOrganName; // Người thân bạn bè BVB - Họ tên
	private String referOrganPosition; // Người thân bạn bè BVB - Chức vụ
	private String referOrganWorkUnit; // Người thân bạn bè BVB - Đơn vị công tác
	private String referOrganRelationShip; // Người thân bạn bè BVB - Mối quan hệ
	private String referOrganMobile; // Người thân bạn bè BVB - Mobile
	private String referOrganEmail; // Người thân bạn bè BVB - Email
	private String referOrganDescription; // Người thân bạn bè BVB - Ghi chú thêm
	private String referOtherLocation; // Thông tin tham khảo khác - Vị trí
	private String referOtherDate; // Thông tin tham khảo khác - Thời gian

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	private Date contractRealDate; // Thông tin HĐLĐ ban đầu - Ngày vào thực tế
	private String contractRealShortDate; // Thông tin HĐLĐ ban đầu - Tháng/Năm
	private int contractType; // Thông tin HĐLĐ ban đầu - Loại hợp đồng (=1:Học việc;=2:thử việc;=3:chính
								// thức;=99:Other)
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	private Date contractDurationDate; // Thông tin HĐLĐ ban đầu - Thời hạn hợp đồng
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	private Date contractBeginDate; // Thông tin HĐLĐ ban đầu - HĐLĐ: Ngày bắt đầu
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	private Date contractEndDate; // Thông tin HĐLĐ ban đầu - HĐLĐ: Ngày kết thúc

	private Double salaryApprentice; // Thông tin thu nhập - Lương học việc
	private Double salaryProbation; // Thông tin thu nhập - Lương thử việc
	private Double salaryOfficial; // Thông tin thu nhập - Lương chính thức
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	private Date salaryOfficialDate; // Thông tin thu nhập - Ngày chính thức
	
	private Double salaryInsurance; // Thông tin thu nhập - LCB tham gia bảo hiểm
	private Double salaryAllowance1; // Thông tin thu nhập - Phụ cấp 1
	private Double salaryAllowance2; // Thông tin thu nhập - Phụ cấp 2

	private String educationType; // TRÌNH ĐỘ ĐẠI HỌC: Trình độ (ĐH, CĐ)
	private String academicMajor; // TRÌNH ĐỘ ĐẠI HỌC: Chuyên ngành
	private String academicEducation; // TRÌNH ĐỘ ĐẠI HỌC: Trường Đại Học
	private int academicGraduationYear; // TRÌNH ĐỘ ĐẠI HỌC: Năm tốt nghiệp
	private String academicCertificateCategory; // TRÌNH ĐỘ ĐẠI HỌC: Xếp loại tốt nghiệp
	private String academicMethod; // TRÌNH ĐỘ ĐẠI HỌC: Hình thức đào tạo
	private String academicCountry; // TRÌNH ĐỘ ĐẠI HỌC: Quốc gia
	private String afterUniversityLevel; // TRÌNH ĐỘ SAU ĐẠI HỌC: Trình độ
	private String afterUniversityMajor; // TRÌNH ĐỘ SAU ĐẠI HỌC: Chuyên ngành
	private String afterUniversityEducation; // TRÌNH ĐỘ SAU ĐẠI HỌC: Trường Đại Học
	private int afterUniversityGraduationYear; // TRÌNH ĐỘ SAU ĐẠI HỌC: Năm tốt nghiệp
	private String afterUniversityCertificateCategory; // TRÌNH ĐỘ SAU ĐẠI HỌC: Xếp loại tốt nghiệp
	private String afterUniversityMethod; // TRÌNH ĐỘ SAU ĐẠI HỌC: Hình thức đào tạo
	private String afterUniversityCountry; // TRÌNH ĐỘ SAU ĐẠI HỌC: Quốc gia
	private String otherEducation; // Các khóa, hình thức đào tạo khác
	private String language1; // NGOẠI NGỮ: Ngoại ngữ 1
	private String language1Description; // NGOẠI NGỮ: Ghi chú
	private String language2; // NGOẠI NGỮ: Ngoại ngữ 2
	private String language2Description; // NGOẠI NGỮ: Ghi chú
	private String languageOther;

	private Collection<FamilyDTO> families;

}
