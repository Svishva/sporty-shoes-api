package com.sportyshoes.models;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Builder;

@Builder
@AllArgsConstructor
public class Order {

	private String orderId;
	private Integer quantity;
	private String userId;
	private LocalDateTime orderDate;
	private Timestamp createTime;
	private String productId;

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public LocalDateTime getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDateTime orderDate) {
		this.orderDate = orderDate;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(orderId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Order)) {
			return false;
		}
		Order other = (Order) obj;
		return Objects.equals(orderId, other.orderId);
	}

	public int compareTo(Order otherOrder) {
		return this.orderId.compareTo(otherOrder.orderId);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Order [orderId=").append(orderId).append(", quantity=").append(quantity).append(", userId=")
				.append(userId).append(", orderDate=").append(orderDate).append(", createTime=").append(createTime)
				.append(", productId=").append(productId).append("]");
		return builder.toString();
	}

}
