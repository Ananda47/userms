package com.infosys.infymarket.user.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(uniqueConstraints= 
           @UniqueConstraint(columnNames={"buyer_id", "email","phone_number"}))

public class Buyer {

	@Id
	@Column(nullable = false)
	String buyer_id;
	@Column(nullable = false)
	String name;
	@Column(nullable = false)
	String email;
	@Column(nullable = false)
	String phone_number;
	@Column(nullable = false)
	String password;
	@Column(length=1,nullable = false)
	String is_active;
	@Column(length=1,nullable = false)
	String is_privileged;
	@Column(nullable = false)
	Integer rewardpoints;
	
	public Buyer() {
		super();
	}

	public String getBuyerid() {
		return buyer_id;
	}

	public void setBuyerid(String buyer_id) {
		this.buyer_id = buyer_id;
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
		return phone_number;
	}

	public void setPhoneno(String phone_number) {
		this.phone_number = phone_number;
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

	public String getIsprivileged() {
		return is_privileged;
	}

	public void setIsprivileged(String is_privileged) {
		this.is_privileged = is_privileged;
	}

	public Integer getRewardpoints() {
		return rewardpoints;
	}

	public void setRewardpoints(Integer rewardpoints) {
		this.rewardpoints = rewardpoints;
	}

	public Buyer(String buyer_id, String name, String email, String phone_number, String password, String is_active,
			String is_privileged, Integer rewardpoints) {
		super();
		this.buyer_id = buyer_id;
		this.name = name;
		this.email = email;
		this.phone_number = phone_number;
		this.password = password;
		this.is_active = is_active;
		this.is_privileged = is_privileged;
		this.rewardpoints = rewardpoints;
	}

	@Override
	public String toString() {
		return "Buyer [buyer_id=" + buyer_id + ", name=" + name + ", email=" + email + ", phone_number=" + phone_number
				+ ", password=" + password + ", is_active=" + is_active + ", is_privileged=" + is_privileged
				+ ", rewardpoints=" + rewardpoints + "]";
	}
	
}
