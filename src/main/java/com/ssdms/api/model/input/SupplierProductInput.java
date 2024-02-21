package com.ssdms.api.model.input;

import java.math.BigDecimal;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.PositiveOrZero;

import com.ssdms.domain.model.SupplierKeyId;

public class SupplierProductInput {

	private SupplierKeyId providerProductId;
	@NotEmpty
	private String supplierCode;
	@PositiveOrZero
	private BigDecimal price;
	@PositiveOrZero
	private BigDecimal amount;
	private boolean ask;

	public SupplierKeyId getProviderProductId() {
		return providerProductId;
	}

	public void setProviderProductId(SupplierKeyId providerProductId) {
		this.providerProductId = providerProductId;
	}

	public String getSupplierCode() {
		return supplierCode;
	}

	public void setSupplierCode(String supplierCode) {
		this.supplierCode = supplierCode;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public boolean isAsk() {
		return ask;
	}

	public void setAsk(boolean ask) {
		this.ask = ask;
	}

}
