package com.ssdms.api.model;

import java.math.BigDecimal;

import javax.validation.constraints.NotBlank;

public class ProductModel {

	@NotBlank
	private String code;
	@NotBlank
	private String description;
	private CategoryModel category;
	private String NCM;
	private String CEST;
	private String GTIN;
	private BigDecimal price;
	private BigDecimal stock;
	private UnitModel unit;
	private String details;

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

	public CategoryModel getCategory() {
		return category;
	}

	public void setCategoria(CategoryModel categoriaModel) {
		this.category = categoriaModel;
	}

	public String getNCM() {
		return NCM;
	}

	public void setNCM(String nCM) {
		NCM = nCM;
	}

	public String getCEST() {
		return CEST;
	}

	public void setCEST(String cEST) {
		CEST = cEST;
	}

	public String getGTIN() {
		return GTIN;
	}

	public void setGTIN(String gTIN) {
		GTIN = gTIN;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public BigDecimal getStock() {
		return stock;
	}

	public void setStock(BigDecimal stock) {
		this.stock = stock;
	}

	public UnitModel getUnit() {
		return unit;
	}

	public void setUnit(UnitModel unit) {
		this.unit = unit;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

}
