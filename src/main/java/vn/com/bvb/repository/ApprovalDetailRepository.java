package vn.com.bvb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import vn.com.bvb.entity.ApprovalDetail;

public interface ApprovalDetailRepository extends JpaRepository<ApprovalDetail,Long> { //extends CrudRepository<Employee, Long> {

}
