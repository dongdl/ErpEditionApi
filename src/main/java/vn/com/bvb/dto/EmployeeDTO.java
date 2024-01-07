package vn.com.bvb.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeDTO {
	
	private long id;

	private String code;

	private String email;

	private String positionCode;

	private Date positionDate;

	private String departmentCode;

	private String zone;

	private String region;

	private String taxCode;

	private String insuranceNumber;
	
	private String accountNumber;
	
	private String status;

	private Date probationaryContractDate;

	private Date officialContractDate;

	private String firstName;

	private String lastName;

	private String fullName;

	private Integer age;

	private Date birthday;

	private Integer gender;

	private String photo;

	private String addressCode;

	private String address;

	private String ethnicCode;

	private String isParty;

	private Date partyDate;

	private String partyPosition;

	private String partyAddress;

	private boolean isArmy;

	private boolean isVeterans;

	private boolean isMartyrsChild;

	private String permanentAddress;

	private String currentAddress;

	private String cardId;

	private Date cardDate;

	private String cardAddress;

	private String passportNumber;

	private Date passportDate;

	private String passportExpiredDate;

	private String homePhone;

	private String mobilePhone;

	private String privateEmail;

	private String maritalStatus;

	private String contactAddress;

	private String contactPhone;

	private String education;

	private String foreignLanguage;

	private String nationalityCode;

	private String description;

}
