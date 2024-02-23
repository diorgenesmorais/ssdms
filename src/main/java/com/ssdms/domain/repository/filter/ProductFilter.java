package com.ssdms.domain.repository.filter;

public class ProductFilter {

	private String code;
	private String description;
	private String GTIN;
	private String categoryName;
	private String unitDescription;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getGTIN() {
		return GTIN;
	}

	public void setGTIN(String gTIN) {
		GTIN = gTIN;
	}

	public boolean isCodePresent() {
		return this.code != null;
	}
	
	public boolean isDescriptionPresent() {
		return this.description != null;
	}
	
	public boolean isGTINPresent() {
		return this.GTIN != null;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public boolean isCategoryPresent() {
		return this.categoryName != null;
	}

	public String getUnitDescription() {
		return unitDescription;
	}

	public void setUnitDescription(String unitDescription) {
		this.unitDescription = unitDescription;
	}

	public boolean isUnitDescriptionPresent() {
		return this.unitDescription != null;
	}
}
