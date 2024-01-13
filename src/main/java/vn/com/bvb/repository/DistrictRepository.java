package vn.com.bvb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import vn.com.bvb.entity.District;

public interface DistrictRepository extends JpaRepository<District,Long> { //extends CrudRepository<Employee, Long> {

}
