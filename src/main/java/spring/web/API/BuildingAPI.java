package spring.web.API;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import spring.web.services.BuildingService;

@RestController
public class BuildingAPI {
	
	
	@Autowired
	private BuildingService buildingSevice ;
	
	@GetMapping(value = "/api/find")
	public Object getAPI(@RequestParam Map<String , Object>params , 
						@RequestParam(name = "typeCode" , required = false ) List<String> typeCode) {
		return buildingSevice.findAll(params, typeCode);
	}
	
	

}
