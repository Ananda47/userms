package com.infosys.infymarket.user.dto;

import com.infosys.infymarket.user.entity.Seller;

public class SellerDTO {

	String seller_id;
	
	String name;
	
	String email;
	
	String phone_num;
	
	String password;

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

	@Override
	public String toString() {
		return "SellerDTO [seller_id=" + seller_id + ", name=" + name + ", email=" + email + ", phone_num=" + phone_num
				+ ", password=" + password + ", is_active=" + is_active + "]";
	}
	
	// Converts Entity into DTO
			public static SellerDTO valueOf(Seller seller) {
				SellerDTO sellerDTO = new SellerDTO();
				sellerDTO.setSellerid(seller.getSellerid());
				sellerDTO.setName(seller.getName());
				sellerDTO.setEmail(seller.getEmail());
				sellerDTO.setPhoneno(seller.getPhoneno());
				sellerDTO.setPassword(seller.getPassword());
				sellerDTO.setIsactive(seller.getIsactive());
    return sellerDTO;
}
			public Seller createSeller() {
	            Seller seller = new Seller();
	            seller.setSellerid(this.getSellerid());
	            seller.setName(this.getName());
	            seller.setPhoneno(this.getPhoneno());
	            seller.setEmail(this.getEmail());
	            seller.setPassword(this.getPassword());
	            seller.setIsactive(this.getIsactive());
	            return seller;
	        }
}
