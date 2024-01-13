package vn.com.bvb.service;

import java.util.List;

import org.springframework.stereotype.Service;

import vn.com.bvb.dto.CountryDTO;
import vn.com.bvb.dto.DepartmentDTO;
import vn.com.bvb.dto.DistrictDTO;
import vn.com.bvb.dto.EthnicDTO;
import vn.com.bvb.dto.ProvinceDTO;
import vn.com.bvb.dto.WardComuneDTO;

@Service
public interface MasterDataService {

	List<CountryDTO> findAllCountries();
	
	List<DepartmentDTO> findAllDepartments();
	
	List<DistrictDTO> findAllDistricts();

	List<EthnicDTO> findAllEthnics();

	List<ProvinceDTO> findAllProvinces();

	List<WardComuneDTO> findAllWardComunes();
	
}
