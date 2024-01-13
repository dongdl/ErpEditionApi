package vn.com.bvb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import vn.com.bvb.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department,Long> { //extends CrudRepository<Employee, Long> {

}
