package vn.com.bvb.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import vn.com.bvb.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Long> { //extends CrudRepository<Employee, Long> {

	Optional<Employee> findByCode(String code);
}
