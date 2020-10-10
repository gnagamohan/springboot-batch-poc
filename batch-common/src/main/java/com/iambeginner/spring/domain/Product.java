package com.iambeginner.spring.domain;

import java.io.Serializable;
import java.math.BigDecimal;

public class Product implements Serializable {

	private static final long serialVersionUID = -8869573714454080812L;
	private String id;
	private String displayName;
	private BigDecimal price;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDisplayName() {
		return displayName;
	}
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", displayName=" + displayName + ", price=" + price + "]";
	}
	
}
