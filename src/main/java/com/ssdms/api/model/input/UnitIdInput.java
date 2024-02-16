package com.ssdms.api.model.input;

import javax.validation.constraints.NotNull;

public class UnitIdInput {

	@NotNull
	private Integer id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
