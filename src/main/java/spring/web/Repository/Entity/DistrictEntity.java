package spring.web.Repository.Entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import spring.*;


@Entity
@Table(name = "district")
public class DistrictEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id ; 
	
	@OneToMany(mappedBy ="district" , fetch = FetchType.LAZY)
	List<BuildingEntity> builds = new ArrayList<>() ; 
	
	@Column(name =  "code")
	private String code ; 
	
	
	@Column(name = "name")
	private String name ;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public List<BuildingEntity> getBuilds() {
		return builds;
	}


	public void setBuilds(List<BuildingEntity> builds) {
		this.builds = builds;
	}


	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	} 
	
	
}
