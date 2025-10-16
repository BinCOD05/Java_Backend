package spring.web.Converter;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import spring.web.Repository.Entity.BuildingEntity;
import spring.web.model.BuildingDTO;




@Component
public class BuildingDTOConvertor {
	
	@Autowired
	ModelMapper modelMapper ; 
	
	public BuildingDTO toBuildingConvertor(BuildingEntity data) {
		BuildingDTO buildingDTO  =  modelMapper.map(data, BuildingDTO.class); 
		
		buildingDTO.setName(data.getName());
		buildingDTO.setInfo(data.getStreet() + " " + data.getWard());
		
		
		return buildingDTO ; 
	}
}	
