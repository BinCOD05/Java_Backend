package spring.web.Repository.Custom;

import java.util.List;

import spring.web.Partern.BuilderSearchParttern;
import spring.web.Repository.Entity.BuildingEntity;

public interface BuildingRepositoryCustom {
	List<BuildingEntity> findAll(BuilderSearchParttern builderSearchParttern); 
}
