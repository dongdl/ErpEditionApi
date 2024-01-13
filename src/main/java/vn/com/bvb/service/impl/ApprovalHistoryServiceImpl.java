package vn.com.bvb.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.AllArgsConstructor;
import vn.com.bvb.dto.ApprovalHistoryDTO;
import vn.com.bvb.mapper.ApprovalHistoryMappingManager;
import vn.com.bvb.repository.ApprovalHistoryRepository;
import vn.com.bvb.service.ApprovalHistoryService;

@Service
@AllArgsConstructor
public class ApprovalHistoryServiceImpl implements ApprovalHistoryService {

	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	private ApprovalHistoryRepository approvalHistoryRepository;
	
	private ApprovalHistoryMappingManager approvalHistoryMappingManager;

	@Override
	@Transactional
	public List<ApprovalHistoryDTO> findAll(long employeeId) {
		logger.info("Get All Approval History by employeeId = {}", employeeId);
		return approvalHistoryRepository.findByEmployeeId(employeeId)
				.stream()
				.map(approvalHistory -> approvalHistoryMappingManager.map(approvalHistory))
				.collect(Collectors.toList());
		
	}


}
