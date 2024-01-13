package vn.com.bvb.mapper;

import org.mapstruct.Mapper;

import vn.com.bvb.dto.FamilyDTO;
import vn.com.bvb.entity.Family;

@Mapper(componentModel = "spring")
public interface FamilyMappingManager {
	
	FamilyDTO map(Family family);
	
	Family map(FamilyDTO familyDTO);
	
}
