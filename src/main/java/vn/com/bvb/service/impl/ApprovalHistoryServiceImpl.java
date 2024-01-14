package vn.com.bvb.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.AllArgsConstructor;
import vn.com.bvb.dto.ApprovalHistoryDTO;
import vn.com.bvb.entity.ApprovalDetail;
import vn.com.bvb.mapper.ApprovalHistoryMappingManager;
import vn.com.bvb.repository.ApprovalDetailRepository;
import vn.com.bvb.repository.ApprovalHistoryRepository;
import vn.com.bvb.service.ApprovalHistoryService;

@Service
@AllArgsConstructor
public class ApprovalHistoryServiceImpl implements ApprovalHistoryService {

	private final Logger logger = LoggerFactory.getLogger(getClass());

	private ApprovalHistoryRepository approvalHistoryRepository;

	private ApprovalDetailRepository approvalDetailRepository;

	private ApprovalHistoryMappingManager approvalHistoryMappingManager;

	@Override
	@Transactional
	public List<ApprovalHistoryDTO> findAll(long employeeId) {
		logger.info("Get All Approval History by employeeId = {}", employeeId);
		return approvalHistoryRepository.findByEmployeeIdOrderByIdDesc(employeeId)
				.stream()
				.map(approvalHistory -> {
					ApprovalHistoryDTO approvalHistoryDTO = approvalHistoryMappingManager.map(approvalHistory);
					Optional<ApprovalDetail> opt = approvalDetailRepository.findByTaskId(approvalHistory.getTaskId());
					if (opt.isPresent()) {
						ApprovalDetail approvalDetail = opt.get();
						String commentDetail = approvalDetail.getCommentDetail() != null ? approvalDetail.getCommentDetail(): "";
						String action = approvalDetail.getAction() != null ? approvalDetail.getAction() : "";
						String note = "";
						if (commentDetail.isEmpty() & !action.isEmpty()) {
							note = action;
						} else if (!commentDetail.isEmpty() & action.isEmpty()) {
							note = commentDetail;
						} else if (!commentDetail.isEmpty() & !action.isEmpty()) {
							note = action + "-" + commentDetail;
						}
						approvalHistoryDTO.setCommentDetail(note);
					}
				
					return approvalHistoryDTO;
				})
				.collect(Collectors.toList());
		
	}

}
