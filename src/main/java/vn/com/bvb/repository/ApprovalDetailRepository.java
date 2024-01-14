package vn.com.bvb.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import vn.com.bvb.entity.ApprovalDetail;

public interface ApprovalDetailRepository extends JpaRepository<ApprovalDetail,Long> { 
	
	Optional<ApprovalDetail> findByTaskId(String taskId);

}
