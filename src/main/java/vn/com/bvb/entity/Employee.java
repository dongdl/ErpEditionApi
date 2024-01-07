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
@Entity(name = "employee")
public class Employee extends Person {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "code")
	private String code;

	@Column(name = "email")
	private String email;

	@Column(name = "position_code")
	private String positionCode;

	@Column(name = "position_date")
	private Date positionDate;

	@Column(name = "department_code")
	private String departmentCode;

	@Column(name = "zone")
	private String zone;

	@Column(name = "region")
	private String region;

	@Column(name = "taxCode")
	private String taxCode;

	@Column(name = "insurance_number")
	private String insuranceNumber;
	
	@Column(name = "account_number")
	private String accountNumber;
	
	@Column(name = "status")
	private String status;

	@Column(name = "probationary_contract_date")
	private Date probationaryContractDate;

	@Column(name = "official_contract_Date")
	private Date officialContractDate;

}
