package spring.web.Partern;

import java.util.List;

public class BuilderSearchParttern {
	private String name;
	private List<String> typeCode;
	private Long staffId;
	private String ward;
	private String managerName;
	private Long districtId;
	private String street;
	private Long areaFrom;
	private Long areaTo;
	private Long rentPriceFrom;
	private Long rentPriceTo;

	public String getName() {
		return name;
	}

	public List<String> getTypeCode() {
		return typeCode;
	}

	public Long getStaffId() {
		return staffId;
	}

	public String getWard() {
		return ward;
	}

	public String getManagerName() {
		return managerName;
	}

	public Long getDistrictId() {
		return districtId;
	}

	public String getStreet() {
		return street;
	}

	public Long getAreaFrom() {
		return areaFrom;
	}

	public Long getAreaTo() {
		return areaTo;
	}

	public Long getRentPriceFrom() {
		return rentPriceFrom;
	}

	public Long getRentPriceTo() {
		return rentPriceTo;
	}

	public static class Builder {
		private String name;
		private List<String> typeCode;
		private Long staffId;
		private String ward;
		private String managerName;
		private Long districtId;
		private String street;
		private Long areaFrom;
		private Long areaTo;
		private Long rentPriceFrom;
		private Long rentPriceTo;

		public Builder setName(String name) {
			this.name = name;
			return this;

		}

		public Builder setTydeCode(List<String> typeCode) {
			this.typeCode = typeCode;
			return this;
		}

		public Builder setStaffId(Long staffId) {
			this.staffId = staffId;
			return this;
		}

		public Builder setWard(String ward) {
			this.ward = ward;
			return this;
		}

		public Builder setManagerName(String managerName) {
			this.managerName = managerName;
			return this;
		}

		public Builder setDistrictId(Long districtId) {
			this.districtId = districtId;
			return this;
		}

		public Builder setStreet(String street) {
			this.street = street;
			return this;
		}

		public Builder setAreaFrom(Long areaFrom) {
			this.areaFrom = areaFrom;
			return this;
		}

		public Builder setAreaTo(Long areaTo) {
			this.areaTo = areaTo;
			return this;
		}

		public Builder setRentPriceTo(Long rentPriceTo) {
			this.rentPriceTo = rentPriceTo;
			return this;
		}

		public Builder setRentPriceFrom(Long rentPriceFrom) {
			this.rentPriceFrom = rentPriceFrom;
			return this;
		}

		public BuilderSearchParttern build() {
			return new BuilderSearchParttern(this);
		}

	}

	private BuilderSearchParttern(Builder builder) {
		this.areaFrom = builder.areaFrom;
		this.areaTo = builder.areaTo;
		this.districtId = builder.districtId;
		this.managerName = builder.managerName;
		this.name = builder.name;
		this.staffId = builder.staffId;
		this.street = builder.street;
		this.typeCode = builder.typeCode;
		this.ward = builder.ward;
		this.rentPriceFrom = builder.rentPriceFrom;
		this.rentPriceTo = builder.rentPriceTo;
	}
}
