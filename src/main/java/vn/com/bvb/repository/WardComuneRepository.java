package vn.com.bvb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import vn.com.bvb.entity.WardComune;

public interface WardComuneRepository extends JpaRepository<WardComune,Long> { //extends CrudRepository<Employee, Long> {

}
