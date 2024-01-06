package vn.com.bvb.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import vn.com.bvb.entity.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {

	Optional<Employee> findByCode(String code);

}
