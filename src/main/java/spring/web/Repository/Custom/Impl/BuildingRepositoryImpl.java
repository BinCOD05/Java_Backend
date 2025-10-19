package spring.web.Repository.Custom.Impl;

import java.sql.Statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.lang.reflect.*;
import javax.sql.rowset.Joinable;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import spring.web.Partern.BuilderSearchParttern;
import spring.web.Repository.BuildingRepository;
import spring.web.Repository.Custom.BuildingRepositoryCustom;
import spring.web.Repository.Entity.BuildingEntity;
import spring.web.Utils.*;


@Repository
@Primary
public class BuildingRepositoryImpl implements BuildingRepositoryCustom {
	
	@PersistenceContext
	private EntityManager entityManager ; 
	
	private static void joinTable(BuilderSearchParttern builderSearchParttern ,  StringBuilder sql) {
		Long staffId = builderSearchParttern.getStaffId();
		if( staffId != null ) {
			sql.append(" INNER JOIN assignmentbuilding ON b.id  = assignbuilding.buildingid");
		}
		
		List<String> typeCode = builderSearchParttern.getTypeCode() ; 
		
		if(typeCode != null && typeCode.size() != 0) {
			sql.append(" INNER JOIN buildingrenttype ON b.id = buildingrenttype.buildingid");
			sql.append(" INNER JOIN renttype ON b.id = renttype.id");
		}
		
		
		Long rentAreaTo  = builderSearchParttern.getAreaTo() ; 
		Long rentAreaFrom  = builderSearchParttern.getAreaFrom() ; 
		if(rentAreaFrom != null  || rentAreaTo != null) {
			sql.append(" INNER JOIN rentarea on b.id = rentarea.buildingid");
		}
		
	}
	
	
	
	private static void queryNomal(BuilderSearchParttern builderSearchParttern, StringBuilder where) {
				
//		for(Map.Entry<String, Object> it :  params.entrySet()) {
//			if(!it.getKey().equals("staffId") && !it.getKey().equals("typeCode") && !it.getKey().startsWith("area") && !it.getKey().startsWith("price")) {
//				String value = (String)it.getValue();
//				if(NumberUtil.isNumber(value)) {
//					where.append(" AND b." + it.getKey() +" = " + value);
//				}
//				else {
//					where.append(" AND b." + it.getKey() + " LIKE '%" + value + "%'");
//				}
//			}
//		}
		
		try {
			Field[] fields =  BuilderSearchParttern.class.getDeclaredFields() ; 
			
			for(Field item : fields) {
				item.setAccessible(true);
				String name = item.getName() ; 
				if(!name.equals("staffId") && !name.equals("typeCode") && !name.startsWith("area") && !name.equals("rent") ) {
					Object value = item.get(builderSearchParttern) ; 
					if(value != null && value.getClass().getTypeName().toString().equals("java.lang.String")){
						where.append(" AND b." + name + " LIKE " + "'%" + value + "%'");
					}
					else if (value != null && value.getClass().getTypeName().equals("java.lang.Long")) {
						where.append(" AND b." + name + " = " + value ) ; 
					}
				}
			}
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	
	
	private static void querySpecial(BuilderSearchParttern builderSearchParttern,  StringBuilder where) {
//		String staffId = (String)params.get("staffId");
//		String rentAreaTo = (String)params.get("areaTo");
//		String rentAreaFrom = (String)params.get("areaFrom");
//		String rentPriceTo = (String)params.get("priceTo");
//		String rentPriceFrom = (String)params.get("priceFrom");
		Long staffId = builderSearchParttern.getStaffId() ; 
		Long  rentAreaTo = builderSearchParttern.getAreaTo(); 
		Long rentAreaFrom = builderSearchParttern.getAreaFrom();
		Long rentPriceTo = builderSearchParttern.getRentPriceTo();
		Long rentPriceFrom = builderSearchParttern.getRentPriceFrom();
		List<String> typeCode = builderSearchParttern.getTypeCode() ; 
		
		
		if(staffId != null ) {
			where.append(" AND assignmentbuilding.staffid = " + staffId );
		}
		
//		query theo gia nha
		if(rentPriceFrom != null  || rentPriceTo != null ) {
			if(rentPriceFrom != null ) {
				where.append(" AND building.rentprice >= " + rentPriceFrom);
			}
			if(rentPriceTo != null ) {
				where.append(" AND building.rentprice <= " + rentPriceTo);
			}
		}
//		query theo dien tich 
		
		if(rentAreaFrom != null  || rentAreaTo != null ) {
			if(rentAreaFrom != null ) {
				where.append(" AND rentarea.value >= " + rentAreaFrom);
			}
			if(rentAreaTo != null ) {
				where.append(" AND rentarea.value <= " + rentAreaTo);
			}
		}
		
		if(typeCode != null && typeCode.size() != 0) {
			String inList = typeCode.stream()
					.map(s -> "'" + s + "'")
					.collect(Collectors.joining(","));
			where.append(" AND renttype.code IN (" + inList + ")");
		}
		
		
		
	}
	
	
	@Override
	public List<BuildingEntity> findAll(BuilderSearchParttern builderSearchParttern) {
		// TODO Auto-generated method stub
//		StringBuilder sql = new StringBuilder(" Select b.id, b.name , b.districtid , b.street , b.ward  , b.numberofbasement ,"
//				+ " b.floorarea , b.managername , b.managerphonenumber , b.rentprice , b.servicefee "
//				+ ", b.brokeragefee FROM building b ") ;  
//		nên dùng select * 
		StringBuilder sql = new StringBuilder("SELECT b.* FROM building b ");
		StringBuilder where = new StringBuilder(" WHERE 1 = 1 ");
		List<String> typeCode = builderSearchParttern.getTypeCode() ; 
		joinTable(builderSearchParttern , sql);
		queryNomal(builderSearchParttern, where);
		querySpecial(builderSearchParttern, where);
		where.append(" GROUP BY b.id ;");
		sql.append(where);
		Query query = entityManager.createNativeQuery(sql.toString(), BuildingEntity.class) ; 
		return query.getResultList() ; 
		
//		List<BuildingEntity> result = new ArrayList<BuildingEntity>();
		
//		try( Connection conn = ConnectionDB.getConnection() ; 
//			Statement stmt = conn.createStatement();
//			ResultSet rs = stmt.executeQuery(sql.toString());
//				){
//			while(rs.next()) {
//				BuildingEntity entity = new BuildingEntity();
//				entity.setId(rs.getLong("id"));
//				entity.setName(rs.getString("name"));
//				entity.setBrokerageFee(rs.getLong("brokeragefee"));
//				entity.setDistrictId(rs.getLong("districtid"));
//				entity.setFloorArea(rs.getLong("floorarea"));
//				entity.setManagerName(rs.getString("managername"));
//				entity.setNumberOfBasement(rs.getLong("numberofbasement"));
//				entity.setRentPrice(rs.getLong("rentprice"));
//				entity.setServiceFee(rs.getLong("servicefee"));
//				entity.setManagerPhoneNumber(rs.getString("managerphonenumber"));
//				entity.setStreet(rs.getString("street"));
//				entity.setWard(rs.getString("ward"));
//				result.add(entity);
//			}
//			System.out.println(result.get(0).getBrokerageFee() + " " + result.get(0).getBrokerageFee()); 
			
//		}catch (SQLException e) {
//			e.printStackTrace();
//		}
//		
//		return result;
	}
		
}
