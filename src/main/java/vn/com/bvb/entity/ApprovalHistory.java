package vn.com.bvb.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@Entity(name = "approval_history")
@EntityListeners(AuditingEntityListener.class)
public class ApprovalHistory extends BaseEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "employeeId")
	private long employeeId;

	@Column(name = "taskId")
	private String taskId;
	
	@Column(name = "taskName")
	private String taskName;
	
	@Column(name = "assignee")
	private String assignee;
	
}
