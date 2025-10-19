package spring.web.Repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import spring.web.Partern.BuilderSearchParttern;
import spring.web.Repository.Custom.BuildingRepositoryCustom;
import spring.web.Repository.Entity.*;

public interface BuildingRepository extends JpaRepository<BuildingEntity, Long>, BuildingRepositoryCustom {
}
