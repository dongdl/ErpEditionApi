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

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@Entity(name = "recruitment_user_task")
public class RecruitmentUserTask {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "assignee")
	private String assignee;
	
	@Column(name = "employeeId")
	private long employeeId;
	
	@Column(name = "taskId")
	private String taskId;
	
	@Column(name = "status")
	private String status;

}
