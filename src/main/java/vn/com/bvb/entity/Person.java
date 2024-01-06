package vn.com.bvb.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Person extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "full_name")
	private String fullName;

	@Column(name = "age")
	private Integer age;

	@Column(name = "birth_day")
	private Date birthday;

	@Column(name = "gender")
	private Integer gender;

	@Column(name = "photo")
	private String photo;

	@Column(name = "address_code")
	private String addressCode;

	@Column(name = "address")
	private String address;

	@Column(name = "ethnic_code")
	private String ethnicCode;

	@Column(name = "is_party")
	private String isParty;

	@Column(name = "party_date")
	private Date partyDate;

	@Column(name = "party_position")
	private String partyPosition;

	@Column(name = "party_address")
	private String partyAddress;

	@Column(name = "is_army")
	private boolean isArmy;

	@Column(name = "is_veterans")
	private boolean isVeterans;

	@Column(name = "is_martyrs_child")
	private boolean isMartyrsChild;

	@Column(name = "permanent_address")
	private String permanentAddress;

	@Column(name = "current_address")
	private String currentAddress;

	@Column(name = "card_id")
	private String cardId;

	@Column(name = "card_date")
	private Date cardDate;

	@Column(name = "card_address")
	private String cardAddress;

	@Column(name = "passport_number")
	private String passportNumber;

	@Column(name = "passport_date")
	private Date passportDate;

	@Column(name = "passport_expired_date")
	private String passportExpiredDate;

	@Column(name = "home_phone")
	private String homePhone;

	@Column(name = "mobile_phone")
	private String mobilePhone;

	@Column(name = "private_email")
	private String privateEmail;

	@Column(name = "marital_status")
	private String maritalStatus;

	@Column(name = "contact_address")
	private String contactAddress;

	@Column(name = "contact_phone")
	private String contactPhone;

	@Column(name = "education")
	private String education;

	@Column(name = "foreign_language")
	private String foreignLanguage;

	@Column(name = "nationality_code")
	private String nationalityCode;

	@Column(name = "description")
	private String description;

}
