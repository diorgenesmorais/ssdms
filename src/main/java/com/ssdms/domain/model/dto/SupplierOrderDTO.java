package com.ssdms.domain.model.dto;

import java.time.OffsetDateTime;

public class SupplierOrderDTO {

	private Integer id;
	private OffsetDateTime dateOrdered;
	private Integer providerId;

	public SupplierOrderDTO() {
		super();
	}

	public SupplierOrderDTO(Integer id, OffsetDateTime dateOrdered, Integer providerId) {
		this();
		this.id = id;
		this.dateOrdered = dateOrdered;
		this.providerId = providerId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public OffsetDateTime getDateOrdered() {
		return dateOrdered;
	}

	public void setDateOrdered(OffsetDateTime dateOrdered) {
		this.dateOrdered = dateOrdered;
	}

	public Integer getProviderId() {
		return providerId;
	}

	public void setProviderId(Integer providerId) {
		this.providerId = providerId;
	}

}
