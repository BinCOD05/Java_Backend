package spring.web.services;
import java.util.List;
import java.util.Map;

import spring.web.model.*;
public interface BuildingService {
		public List<BuildingDTO> findAll(Map<String , Object> params , List<String> typeCode);
		
		public BuildingDTO findById(Long id) ; 
		
		
}	
