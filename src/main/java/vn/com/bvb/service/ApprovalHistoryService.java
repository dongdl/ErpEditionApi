package vn.com.bvb.service;

import java.util.List;

import org.springframework.stereotype.Service;

import vn.com.bvb.dto.ApprovalHistoryDTO;

@Service
public interface ApprovalHistoryService {

	List<ApprovalHistoryDTO> findAll(long employeeId);
	
}
