package com.infosys.infymarket.user.entity;


import javax.persistence.Column;



public class Product {

	
	
	String prod_id;
	
	String product_name;
	
	Double price;
	
	Integer stock;
	
	String description;
	
	String image;
	
	String seller_id;
	
	String category;
	
	String subcategory;
	
	Integer productrating;
	public String getBuyerid() {
		return buyer_id;
	}
	public void setBuyerid(String buyer_id) {
		this.buyer_id = buyer_id;
	}
	@Column(name = "buyer_id",nullable = false)
	String buyer_id;
	
	public String getProdid() {
		return prod_id;
	}
	public void setProdid(String prod_id) {
		this.prod_id = prod_id;
	}
	public String getProductname() {
		return product_name;
	}
	public void setProductname(String product_name) {
		this.product_name = product_name;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Integer getStock() {
		return stock;
	}
	public void setStock(Integer stock) {
		this.stock = stock;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getSellerid() {
		return seller_id;
	}
	public void setSellerid(String seller_id) {
		this.seller_id = seller_id;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getSubcategory() {
		return subcategory;
	}
	public void setSubcategory(String subcategory) {
		this.subcategory = subcategory;
	}
	public Integer getProductrating() {
		return productrating;
	}
	public void setProductrating(Integer productrating) {
		this.productrating = productrating;
	}

	

	
}


