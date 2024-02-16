package com.ssdms.api.model.input;

import java.math.BigDecimal;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

import org.springframework.lang.NonNull;

public class ProductInput {

	@NotBlank
	private String code;
	@NotBlank
	private String description;
	@Valid
	@NotNull
	private CategoryIdInput category;
	private String NCM;
	private String CEST;
	private String GTIN;
	@NotNull
	@PositiveOrZero
	private BigDecimal price;
	@NotNull
	private BigDecimal stock;
	@Valid
	@NotNull
	private UnitIdInput unit;
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

	public CategoryIdInput getCategory() {
		return category;
	}

	public void setCategory(@NonNull CategoryIdInput category) {
		this.category = category;
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

	public UnitIdInput getUnit() {
		return unit;
	}

	public void setUnit(@NonNull UnitIdInput unit) {
		this.unit = unit;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

}
