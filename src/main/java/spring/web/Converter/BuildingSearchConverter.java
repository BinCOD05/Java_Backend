package spring.web.Converter;


import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import spring.web.Partern.*;
import spring.web.Utils.MapUtil;


@Component
public class BuildingSearchConverter {
	
	
	
	public BuilderSearchParttern toBuilderSearchParttern(Map<String , Object> params , List<String> typeCode) {
		BuilderSearchParttern builderSearchParttern = new BuilderSearchParttern.Builder()
				.setName(MapUtil.checkObject(params, "name", String.class))
				.setAreaFrom(MapUtil.checkObject(params, "areaFron", Long.class))
				.setAreaTo(MapUtil.checkObject(params, "areaTo", Long.class))
				.setDistrictId(MapUtil.checkObject(params, "districtId", Long.class))
				.setManagerName(MapUtil.checkObject(params, "managerName", String.class))
				.setStaffId(MapUtil.checkObject(params,"staffId", Long.class))
				.setStreet(MapUtil.checkObject(params, "street", String.class))
				.setRentPriceFrom(MapUtil.checkObject(params, "rentPriceFrom", Long.class))
				.setRentPriceTo(MapUtil.checkObject(params, "rentPriceTo", Long.class))
				.setTydeCode(typeCode)
				.setWard(MapUtil.checkObject(params, "ward", String.class))
				.build();
		return builderSearchParttern; 
		
	}
}
