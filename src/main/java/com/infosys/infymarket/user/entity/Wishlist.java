package com.infosys.infymarket.user.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Wishlist implements Serializable{

		@Id
		@Column(name = "buyer_id",nullable = false)
		String buyer_id;
		@Column(name = "prod_id",nullable = false)
		String prod_id;
		public Wishlist() {
			
		}
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
		public Wishlist(String buyer_id, String prod_id) {
			super();
			this.buyer_id = buyer_id;
			this.prod_id = prod_id;
		}
		@Override
		public String toString() {
			return "Wishlist [buyer_id=" + buyer_id + ", prod_id=" + prod_id + "]";
		}
		
		
}
