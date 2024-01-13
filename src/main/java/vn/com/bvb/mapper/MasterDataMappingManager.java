package vn.com.bvb.mapper;

import org.mapstruct.Mapper;

import vn.com.bvb.dto.CountryDTO;
import vn.com.bvb.dto.DepartmentDTO;
import vn.com.bvb.dto.DistrictDTO;
import vn.com.bvb.dto.EthnicDTO;
import vn.com.bvb.dto.ProvinceDTO;
import vn.com.bvb.dto.WardComuneDTO;
import vn.com.bvb.entity.Country;
import vn.com.bvb.entity.Department;
import vn.com.bvb.entity.District;
import vn.com.bvb.entity.Ethnic;
import vn.com.bvb.entity.Province;
import vn.com.bvb.entity.WardComune;

@Mapper(componentModel = "spring")
public interface MasterDataMappingManager {
	
	CountryDTO map(Country country);
	
	DepartmentDTO map(Department department);

	DistrictDTO map(District district);

	EthnicDTO map(Ethnic ethnic);
	
	ProvinceDTO map(Province province);

	WardComuneDTO map(WardComune wardComune);

}
