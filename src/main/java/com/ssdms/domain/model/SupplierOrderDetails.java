package com.ssdms.domain.model;

import java.math.BigDecimal;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.PositiveOrZero;

import org.springframework.lang.NonNull;

@Entity
@Table(name = "supplier_order_details")
public class SupplierOrderDetails {

	@EmbeddedId
	private OrderKeyId orderKeyId;
	@PositiveOrZero
	private BigDecimal quantity;
	@PositiveOrZero
	private BigDecimal price;
	private boolean confirm;

	public SupplierOrderDetails() {
		super();
	}

	public SupplierOrderDetails(@NonNull Integer orderId, @NonNull Integer productId) {
		this();
		this.orderKeyId = new OrderKeyId(orderId, productId);
	}

	public OrderKeyId getOrderKeyId() {
		return orderKeyId;
	}

	public void setOrderKeyId(OrderKeyId orderKeyId) {
		this.orderKeyId = orderKeyId;
	}

	public BigDecimal getQuantity() {
		return quantity;
	}

	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public boolean isConfirm() {
		return confirm;
	}

	public void setConfirm(boolean confirm) {
		this.confirm = confirm;
	}

}
