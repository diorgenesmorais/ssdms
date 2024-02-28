package com.ssdms.domain.model;

import java.time.OffsetDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "supplier_order")
public class SupplierOrder {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@NotNull
	@Column(name = "date_ordered")
	private OffsetDateTime dateOrdered;
	@NotNull
	@ManyToOne
	@JoinColumn(name = "provider_id", nullable = false)
	private Providers provider;

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

	public Providers getProvider() {
		return provider;
	}

	public void setProvider(Providers provider) {
		this.provider = provider;
	}

}
