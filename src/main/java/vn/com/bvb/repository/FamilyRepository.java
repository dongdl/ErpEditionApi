package vn.com.bvb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import vn.com.bvb.entity.ApprovalDetail;
import vn.com.bvb.entity.Family;

public interface FamilyRepository extends JpaRepository<Family,Long> { //extends CrudRepository<Employee, Long> {

	List<Family> findByEmployeeId(long employeeId);
}
