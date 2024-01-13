package vn.com.bvb.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.AllArgsConstructor;
import vn.com.bvb.dto.CountryDTO;
import vn.com.bvb.dto.DepartmentDTO;
import vn.com.bvb.dto.DistrictDTO;
import vn.com.bvb.dto.EthnicDTO;
import vn.com.bvb.dto.ProvinceDTO;
import vn.com.bvb.dto.WardComuneDTO;
import vn.com.bvb.mapper.MasterDataMappingManager;
import vn.com.bvb.repository.CountryRepository;
import vn.com.bvb.repository.DepartmentRepository;
import vn.com.bvb.repository.DistrictRepository;
import vn.com.bvb.repository.EthnicRepository;
import vn.com.bvb.repository.ProvinceRepository;
import vn.com.bvb.repository.WardComuneRepository;
import vn.com.bvb.service.MasterDataService;

@Service
@AllArgsConstructor
public class MasterDataServiceImpl implements MasterDataService {

	private CountryRepository countryRepository;
	
	private DepartmentRepository departmentRepository;
	
	private DistrictRepository districtRepository;
	
	private EthnicRepository ethnicRepository;
	
	private ProvinceRepository provinceRepository;
	
	private WardComuneRepository wardComuneRepository;
	
	private MasterDataMappingManager masterDataMappingManager;

	@Override
	@Transactional
	public List<CountryDTO> findAllCountries() {
		return countryRepository.findAll()
				.stream()
				.map(country -> masterDataMappingManager.map(country))
				.collect(Collectors.toList());
	}

	@Override
	@Transactional
	public List<DepartmentDTO> findAllDepartments() {
		return departmentRepository.findAll()
				.stream()
				.map(department -> masterDataMappingManager.map(department))
				.collect(Collectors.toList());
	}

	@Override
	@Transactional
	public List<DistrictDTO> findAllDistricts() {
		return districtRepository.findAll()
				.stream()
				.map(district -> masterDataMappingManager.map(district))
				.collect(Collectors.toList());
	}

	@Override
	@Transactional
	public List<EthnicDTO> findAllEthnics() {
		return ethnicRepository.findAll()
				.stream()
				.map(ethnic -> masterDataMappingManager.map(ethnic))
				.collect(Collectors.toList());
	}

	@Override
	@Transactional
	public List<ProvinceDTO> findAllProvinces() {
		return provinceRepository.findAll()
				.stream()
				.map(province -> masterDataMappingManager.map(province))
				.collect(Collectors.toList());
	}

	@Override
	@Transactional
	public List<WardComuneDTO> findAllWardComunes() {
		return wardComuneRepository.findAll()
				.stream()
				.map(wardComune -> masterDataMappingManager.map(wardComune))
				.collect(Collectors.toList());
	}
	
}
