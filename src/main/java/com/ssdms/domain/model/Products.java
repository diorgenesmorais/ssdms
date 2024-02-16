package com.ssdms.domain.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "products")
public class Products {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@NotBlank
	@Column(name = "codigo", nullable = false)
	private String code;
	@NotBlank
	@Column(name = "descricao", nullable = false)
	private String description;
	@NotNull
	@ManyToOne
	@JoinColumn(name = "categoria_id", nullable = false)
	private Category category;
	private String NCM;
	private String CEST;
	private String GTIN;
	@PositiveOrZero
	@Column(name = "preco")
	private BigDecimal price;
	@NotNull
	@Column(name = "estoque")
	private BigDecimal stock;
	@NotNull
	@ManyToOne
	@JoinColumn(name = "unidade_id")
	private Unit unit;
	@Column(name = "detalhes")
	private String details;
	@UpdateTimestamp
	private LocalDate updateAt;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String codigo) {
		this.code = codigo;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String descricao) {
		this.description = descricao;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category categories) {
		this.category = categories;
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

	public void setPrice(BigDecimal preco) {
		this.price = preco;
	}

	public BigDecimal getStock() {
		return stock;
	}

	public void setStock(BigDecimal estoque) {
		this.stock = estoque;
	}

	public Unit getUnit() {
		return unit;
	}

	public void setUnit(Unit units) {
		this.unit = units;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String detalhes) {
		this.details = detalhes;
	}

	public LocalDate getUpdateAt() {
		return updateAt;
	}

	public void setUpdateAt(LocalDate updateAt) {
		this.updateAt = updateAt;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Products other = (Products) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
