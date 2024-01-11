package vn.com.bvb.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import vn.com.bvb.dto.BaseEntityDTO;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@Entity(name = "approval_detail")
public class ApprovalDetail extends BaseEntityDTO {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "employeeId")
	private long employeeId;

	@Column(name = "taskId")
	private String taskId;
	
	@Column(name = "type")
	private String type;

	@Column(name = "action")
	private String action;
	
	@Column(name = "commentCode")
	private String commentCode;
	
	@Column(name = "commentTitle")
	private String commentTitle;
	
	@Column(name = "commentDetail")
	private String commentDetail;
	
}
