package vn.com.bvb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import vn.com.bvb.entity.ApprovalHistory;

public interface ApprovalHistoryRepository extends JpaRepository<ApprovalHistory,Long> { //extends CrudRepository<Employee, Long> {

}
