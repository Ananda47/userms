package com.infosys.infymarket.user.dto;

import com.infosys.infymarket.user.entity.Product;

public class ProductDTO {

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

	public ProductDTO() {
		super();
	}
		
		

	// Converts Entity into DTO
	public static ProductDTO valueOf(Product product) {
		ProductDTO productDTO = new ProductDTO();
		productDTO.setProdid(product.getProdid());
		productDTO.setProductname(product.getProductname());
		productDTO.setPrice(product.getPrice());
		productDTO.setStock(product.getStock());
		productDTO.setDescription(product.getDescription());
		productDTO.setImage(product.getImage());
		productDTO.setSellerid(product.getSellerid());
		productDTO.setCategory(product.getCategory());
		productDTO.setSubcategory(product.getSubcategory());
		productDTO.setProductrating(product.getProductrating());
		return productDTO;
	}
	@Override
	public String toString() {
		return "ProductDTO [prod_id=" + prod_id + ", product_name=" + product_name + ", price=" + price + ", stock=" + stock
				+ ", description=" + description + ", image=" + image + ", seller_id=" + seller_id + ", category="
				+ category + ", subcategory=" + subcategory + ", productrating=" + productrating + "]";
	}
}
