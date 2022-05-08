package com.sportyshoes.models;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Builder;

@Builder
@AllArgsConstructor
public class Product {

	private String productId;
	private String name;
	private BigDecimal msrp;
	private Integer quantityInStock;
	private String productVendor;
	private Timestamp createTime;

	public Product() {
		super();
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getMsrp() {
		return msrp;
	}

	public void setMsrp(BigDecimal msrp) {
		this.msrp = msrp;
	}

	public Integer getQuantityInStock() {
		return quantityInStock;
	}

	public void setQuantityInStock(Integer quantityInStock) {
		this.quantityInStock = quantityInStock;
	}

	public String getProductVendor() {
		return productVendor;
	}

	public void setProductVendor(String productVendor) {
		this.productVendor = productVendor;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Product))
			return false;
		Product other = (Product) obj;
		return Objects.equals(productId, other.productId);
	}

	@Override
	public int hashCode() {
		return Objects.hash(productId);
	}

	public int compareTo(Product otherProduct) {
		return this.productId.compareTo(otherProduct.productId);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Product [productId=").append(productId).append(", name=").append(name).append(", msrp=")
				.append(msrp).append(", quantityInStock=").append(quantityInStock).append(", productVendor=")
				.append(productVendor).append(", createTime=").append(createTime).append("]");
		return builder.toString();
	}

}
