package com.ssdms.api.model.input;

import java.time.OffsetDateTime;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class SupplierOrderInput {

	@NotNull
	private OffsetDateTime dateOrdered;
	@Valid
	@NotNull
	private ProviderIdInput provider;

	public SupplierOrderInput() {
		setDateOrdered(OffsetDateTime.now());
	}

	public OffsetDateTime getDateOrdered() {
		return dateOrdered;
	}

	public void setDateOrdered(OffsetDateTime dateOrdered) {
		this.dateOrdered = dateOrdered;
	}

	public ProviderIdInput getProvider() {
		return provider;
	}

	public void setProvider(ProviderIdInput provider) {
		this.provider = provider;
	}

}
