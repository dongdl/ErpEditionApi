package vn.com.bvb.controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import vn.com.bvb.dto.CountryDTO;
import vn.com.bvb.dto.DepartmentDTO;
import vn.com.bvb.dto.DistrictDTO;
import vn.com.bvb.dto.EthnicDTO;
import vn.com.bvb.dto.ProvinceDTO;
import vn.com.bvb.dto.WardComuneDTO;
import vn.com.bvb.service.MasterDataService;

@Path("/hrm/mdm")
@AllArgsConstructor
@NoArgsConstructor
public class MasterDataController {
	
	@Autowired
	private MasterDataService masterDataService;

	@GET
	@Path(value = "/country")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<CountryDTO> findAllCountries() {
		return masterDataService.findAllCountries();
	}
	
	@GET
	@Path(value = "/department")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<DepartmentDTO> findAllDepartments() {
		return masterDataService.findAllDepartments();
	}
	
	@GET
	@Path(value = "/district")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<DistrictDTO> findAllDistricts() {
		return masterDataService.findAllDistricts();
	}
	
	@GET
	@Path(value = "/ethnic")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<EthnicDTO> findAllEthnics() {
		return masterDataService.findAllEthnics();
	}
	
	@GET
	@Path(value = "/province")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<ProvinceDTO> findAllProvinces() {
		return masterDataService.findAllProvinces();
	}
	
	@GET
	@Path(value = "/ward-comune")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<WardComuneDTO> findAllWardComunes() {
		return masterDataService.findAllWardComunes();
	}
	
	
}
