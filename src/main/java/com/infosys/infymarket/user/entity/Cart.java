package com.infosys.infymarket.user.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Cart {

	@Id
	@Column(nullable = false)
	String buyer_id;
	@Column(nullable = false)
	String prod_id;
	@Column(nullable = false)
	int quantity;

	public String getBuyerid() {
		return buyer_id;
	}

	public void setBuyerid(String buyer_id) {
		this.buyer_id = buyer_id;
	}

	public String getProdid() {
		return prod_id;
	}

	public void setProdid(String prod_id) {
		this.prod_id = prod_id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Cart [buyer_id=" + buyer_id + ", prod_id=" + prod_id + ", quantity=" + quantity + "]";
	}

}
