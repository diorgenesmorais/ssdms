package com.ssdms.api.model;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.dms.useful.UFBrasil;

public class ProviderSummaryModel {

	private String cnpj;
	private String corporateName;
	private String fantasyName;
	@Enumerated(EnumType.STRING)
	private UFBrasil uf;
	private String salesRepresentative;
	private String phoneNumber;
	private String email;
	private String site;
	private String comments;

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getCorporateName() {
		return corporateName;
	}

	public void setCorporateName(String corporateName) {
		this.corporateName = corporateName;
	}

	public String getFantasyName() {
		return fantasyName;
	}

	public void setFantasyName(String fantasyName) {
		this.fantasyName = fantasyName;
	}

	public UFBrasil getUf() {
		return uf;
	}

	public void setUf(UFBrasil uf) {
		this.uf = uf;
	}

	public String getSalesRepresentative() {
		return salesRepresentative;
	}

	public void setSalesRepresentative(String salesRepresentative) {
		this.salesRepresentative = salesRepresentative;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

}
