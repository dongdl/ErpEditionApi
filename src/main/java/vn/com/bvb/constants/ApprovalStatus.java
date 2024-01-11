package vn.com.bvb.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public enum ApprovalStatus {
	
	WAIT_PROCESSING("WAIT_PROCESSING", "WAIT_PROCESSING"),
	PROCESSING("PROCESSING", "PROCESSING"),
	APPROVED("APPROVED", "APPROVED");
	
	private String status;
	
	private String description;

}
