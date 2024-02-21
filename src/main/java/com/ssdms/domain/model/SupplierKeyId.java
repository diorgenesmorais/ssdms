package com.ssdms.domain.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class SupplierKeyId implements Serializable {

	private static final long serialVersionUID = 3614650062436297576L;
	@Column(name = "provider_id")
	private Integer providerId;
	@Column(name = "product_id")
	private Integer productId;

	public Integer getProviderId() {
		return providerId;
	}

	public void setProviderId(Integer providerId) {
		this.providerId = providerId;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(productId, providerId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SupplierKeyId other = (SupplierKeyId) obj;
		return Objects.equals(productId, other.productId) && Objects.equals(providerId, other.providerId);
	}

}
