package com.infosys.infymarket.user.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Seller {
	@Id
	@Column(nullable = false)
	String seller_id;
	@Column(nullable = false)
	String name;
	@Column(nullable = false)
	String email;
	@Column(nullable = false)
	String phone_num;
	@Column(nullable = false)
	String password;
	@Column(nullable = false)
	String is_active;
	public String getSellerid() {
		return seller_id;
	}
	public void setSellerid(String seller_id) {
		this.seller_id = seller_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneno() {
		return phone_num;
	}
	public void setPhoneno(String phone_num) {
		this.phone_num = phone_num;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getIsactive() {
		return is_active;
	}
	public void setIsactive(String is_active) {
		this.is_active = is_active;
	}
	
	public Seller(String seller_id, String name, String email, String phone_num, String password, String is_active) {
		super();
		this.seller_id = seller_id;
		this.name = name;
		this.email = email;
		this.phone_num = phone_num;
		this.password = password;
		this.is_active = is_active;
	}
	public Seller() {
		super();
		
	}
	@Override
	public String toString() {
		return "Seller [seller_id=" + seller_id + ", name=" + name + ", email=" + email + ", phone_num=" + phone_num
				+ ", password=" + password + ", is_active=" + is_active + "]";
	}
	
	
}
