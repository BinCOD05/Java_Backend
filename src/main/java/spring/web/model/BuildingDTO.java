package spring.web.model;

public class BuildingDTO {
		private String name ; 
		private String info ;
		
		private Long districtId;
		private Long numberOfBasement ; 
		private Long floorArea ; 
		private Long rentPrice ; 
		private String managerName ;
		private String managerPhoneNumber ; 
		private Long serviceFee ; 
		private Long brokerageFee ;
		
		
		
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getInfo() {
			return info;
		}
		public void setInfo(String info ) {
			this.info = info; 
		}
		public Long getDistrictId() {
			return districtId;
		}
		public void setDistrictId(Long districtId) {
			this.districtId = districtId;
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
		
		
}
