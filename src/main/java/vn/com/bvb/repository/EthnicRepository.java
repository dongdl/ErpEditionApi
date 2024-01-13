package vn.com.bvb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import vn.com.bvb.entity.Ethnic;

public interface EthnicRepository extends JpaRepository<Ethnic,Long> { //extends CrudRepository<Employee, Long> {

}
