package vn.com.bvb.mapper;

import org.mapstruct.Mapper;

import vn.com.bvb.dto.ApprovalHistoryDTO;
import vn.com.bvb.entity.ApprovalHistory;

@Mapper(componentModel = "spring")
public interface ApprovalHistoryMappingManager {
	
	ApprovalHistoryDTO map(ApprovalHistory approvalHistory);
	
}
