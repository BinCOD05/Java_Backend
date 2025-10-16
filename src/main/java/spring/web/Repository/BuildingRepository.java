package spring.web.Repository;
import java.util.List;
import java.util.Map;

import spring.web.Partern.BuilderSearchParttern;
import spring.web.Repository.Entity.*;
public interface BuildingRepository {
	List<BuildingEntity> findAll(BuilderSearchParttern builderSearchParttern);
}
