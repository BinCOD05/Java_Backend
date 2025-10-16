package spring.web.Repository.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity 
@Table( name = "building")
public class BuildingEntity {
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private Long id ;
	
	@Column(name = "name")
	private String name ;
	
	@Column(name = "street")
	private String street ; 
	
	@Column(name = "ward")
	private String ward ;
	
	
	@ManyToOne
	@JoinColumn(name = "districtid")
	private DistrictEntity district;
	
	
	@Column(name = "numberOfBasement")
	private Long numberOfBasement ; 
	
	@Column(name = "floorArea")
	private Long floorArea ;
	
	@Column(name = "rentPrice")
	private Long rentPrice ; 
	
	@Column(name = "managerName")
	private String managerName ;
	
	@Column(name = "managerPhoneNumber")
	private String managerPhoneNumber ; 
	
	@Column(name = "serviceFee")
	private Long serviceFee ;
	
	@Column(name = "brokerageFee")
	private Long brokerageFee ;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getWard() {
		return ward;
	}

	public void setWard(String ward) {
		this.ward = ward;
	}

	public DistrictEntity getDistrict() {
		return district;
	}

	public void setDistrict(DistrictEntity district) {
		this.district = district;
	}

	public Long getNumberOfBasement() {
		return numberOfBasement;
	}

	public void setNumberOfBasement(Long numberOfBasement) {
		this.numberOfBasement = numberOfBasement;
	}

	public Long getFloorArea() {
		return floorArea;
	}

	public void setFloorArea(Long floorArea) {
		this.floorArea = floorArea;
	}

	public Long getRentPrice() {
		return rentPrice;
	}

	public void setRentPrice(Long rentPrice) {
		this.rentPrice = rentPrice;
	}

	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	public String getManagerPhoneNumber() {
		return managerPhoneNumber;
	}

	public void setManagerPhoneNumber(String managerPhoneNumber) {
		this.managerPhoneNumber = managerPhoneNumber;
	}

	public Long getServiceFee() {
		return serviceFee;
	}

	public void setServiceFee(Long serviceFee) {
		this.serviceFee = serviceFee;
	}

	public Long getBrokerageFee() {
		return brokerageFee;
	}

	public void setBrokerageFee(Long brokerageFee) {
		this.brokerageFee = brokerageFee;
	}
	
	
	
//	private Long id ;
//	private String name ;
//	private String street ; 
//	private String ward ;
//	private Long districtId;
//	private Long numberOfBasement ; 
//	private Long floorArea ; 
//	private Long rentPrice ; 
//	private String managerName ;
//	private String managerPhoneNumber ; 
//	private Long serviceFee ; 
//	private Long brokerageFee ;
//	public Long getId() {
//		return id;
//	}
//	public void setId(Long id) {
//		this.id = id;
//	}
//	public String getName() {
//		return name;
//	}
//	public void setName(String name) {
//		this.name = name;
//	}
//	public String getStreet() {
//		return street;
//	}
//	public void setStreet(String street) {
//		this.street = street;
//	}
//	public String getWard() {
//		return ward;
//	}
//	public void setWard(String ward) {
//		this.ward = ward;
//	}
//	public Long getDistrictId() {
//		return districtId;
//	}
//	public void setDistrictId(Long districtId) {
//		this.districtId = districtId;
//	}
//	public Long getNumberOfBasement() {
//		return numberOfBasement;
//	}
//	public void setNumberOfBasement(Long numberOfBasement) {
//		this.numberOfBasement = numberOfBasement;
//	}
//	public Long getFloorArea() {
//		return floorArea;
//	}
//	public void setFloorArea(Long floorArea) {
//		this.floorArea = floorArea;
//	}
//	public Long getRentPrice() {
//		return rentPrice;
//	}
//	public void setRentPrice(Long rentPrice) {
//		this.rentPrice = rentPrice;
//	}
//	public String getManagerName() {
//		return managerName;
//	}
//	public void setManagerName(String managerName) {
//		this.managerName = managerName;
//	}
//	public String getManagerPhoneNumber() {
//		return managerPhoneNumber;
//	}
//	public void setManagerPhoneNumber(String managerPhoneNumber) {
//		this.managerPhoneNumber = managerPhoneNumber;
//	}
//	public Long getServiceFee() {
//		return serviceFee;
//	}
//	public void setServiceFee(Long serviceFee) {
//		this.serviceFee = serviceFee;
//	}
//	public Long getBrokerageFee() {
//		return brokerageFee;
//	}
//	public void setBrokerageFee(Long brokerageFee) {
//		this.brokerageFee = brokerageFee;
//	}
//	
	
	
	
	
	
	
	
	
}
