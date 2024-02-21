package com.ssdms.domain.model;

import java.math.BigDecimal;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.lang.NonNull;

@Entity
@Table(name = "provider_products")
public class ProviderProducts {

	@EmbeddedId
	private SupplierKeyId supplierKeyId;
	private String supplierCode;
	private BigDecimal price;
	private BigDecimal amount;
	private boolean ask;

	public ProviderProducts() {}

	public ProviderProducts(@NonNull Integer providerId, @NonNull Integer productId) {
		this.supplierKeyId = new SupplierKeyId();
		this.getSupplierKeyId().setProviderId(providerId);
		this.getSupplierKeyId().setProductId(productId);
	}

	public SupplierKeyId getSupplierKeyId() {
		return supplierKeyId;
	}

	public void setSupplierKeyId(SupplierKeyId providerProductId) {
		this.supplierKeyId = providerProductId;
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
