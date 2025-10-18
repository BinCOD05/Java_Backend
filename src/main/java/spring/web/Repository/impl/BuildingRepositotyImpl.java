package spring.web.Repository.impl;

import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.data.annotation.Persistent;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import spring.web.Partern.*;
import spring.web.Repository.BuildingRepository;
import spring.web.Repository.Entity.BuildingEntity;


@Repository

public class BuildingRepositotyImpl  implements BuildingRepository {

	@PersistenceContext
	private EntityManager entityManager ; 
	@Override
	public List<BuildingEntity> findAll(BuilderSearchParttern builderSearchParttern) {	
		String sql = " select * from building " ; 		
		Query query  = entityManager.createNativeQuery(sql, BuildingEntity.class) ; 
		return query.getResultList() ; 
	}

}
