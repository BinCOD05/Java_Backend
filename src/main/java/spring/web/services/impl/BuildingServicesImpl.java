package spring.web.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.web.Converter.BuildingDTOConvertor;
import spring.web.Converter.BuildingSearchConverter;
import spring.web.Partern.BuilderSearchParttern;
import spring.web.Repository.BuildingRepository;
import spring.web.Repository.Entity.BuildingEntity;
import spring.web.model.BuildingDTO;
import spring.web.services.BuildingService;


@Service
public class BuildingServicesImpl implements BuildingService {
	@Autowired
	private BuildingRepository buildingRepository ; 
	
	@Autowired
	private BuildingDTOConvertor buildingDTOConvertor ; 
	
	
	@Autowired
	private BuildingSearchConverter buildingSearchConverter ;
	
	
	@Override
	public List<BuildingDTO> findAll(Map<String , Object> params , List <String> typeCode) {
		// TODO Auto-generated method stub
		
		BuilderSearchParttern builderSearchParttern = buildingSearchConverter.toBuilderSearchParttern(params, typeCode);
		List<BuildingEntity> list = buildingRepository.findAll(builderSearchParttern);
		List<BuildingDTO> result = new ArrayList<BuildingDTO>() ; 
		for( BuildingEntity it : list) {
			BuildingDTO buildingDTO = buildingDTOConvertor.toBuildingConvertor(it) ; 
			result.add(buildingDTO); 
		}
		return result;
	}


	@Override
	public BuildingDTO findById(Long id) {
		BuildingEntity building = buildingRepository.findById(id).get() ;
		
		
		return buildingDTOConvertor.toBuildingConvertor(building) ; 
	}
	
	
	
}
