package com.ssdms.domain.repository.filter;

import java.time.OffsetDateTime;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

public class SupplierOrderFilter {

	@DateTimeFormat(iso = ISO.DATE_TIME)
	private OffsetDateTime startDate;
	@DateTimeFormat(iso = ISO.DATE_TIME)
	private OffsetDateTime endDate;
	private Integer providerId;

	public OffsetDateTime getStartDate() {
		return startDate;
	}

	public void setStartDate(OffsetDateTime startDate) {
		this.startDate = startDate;
	}

	public OffsetDateTime getEndDate() {
		return endDate;
	}

	public void setEndDate(OffsetDateTime endDate) {
		this.endDate = endDate;
	}

	public Integer getProviderId() {
		return providerId;
	}

	public void setProviderId(Integer providerId) {
		this.providerId = providerId;
	}

	public boolean isStartDate() {
		return startDate != null;
	}

	public boolean isEndDate() {
		return endDate != null;
	}

	public boolean isProviderId() {
		return providerId != null;
	}
}
