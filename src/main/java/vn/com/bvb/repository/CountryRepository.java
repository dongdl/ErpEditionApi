package vn.com.bvb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import vn.com.bvb.entity.Country;

public interface CountryRepository extends JpaRepository<Country,Long> { //extends CrudRepository<Employee, Long> {

}
