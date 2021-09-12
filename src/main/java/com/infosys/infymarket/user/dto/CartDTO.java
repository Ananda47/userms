package com.infosys.infymarket.user.dto;

import com.infosys.infymarket.user.entity.Cart;

public class CartDTO {

	String buyer_id;
	ProductDTO prod_id;
	int quantity;

	public String getBuyerid() {
		return buyer_id;
	}

	public void setBuyerid(String buyer_id) {
		this.buyer_id = buyer_id;
	}

	public ProductDTO getProdid() {
		return prod_id;
	}

	public void setProdid(ProductDTO prod_id) {
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
		return "CartDTO [buyer_id=" + buyer_id + ", prod_id=" + prod_id + ", quantity=" + quantity + "]";
	}

	public static CartDTO valueOf(Cart cart) {
		CartDTO cartDTO = new CartDTO();
		cartDTO.setBuyerid(cart.getBuyerid());
		ProductDTO productDTO = new ProductDTO();
		productDTO.setProdid(cart.getProdid());
		cartDTO.setProdid(productDTO);
		cartDTO.setQuantity(cart.getQuantity());
		return cartDTO;
	}
	public Cart createEntity() {
		Cart cart = new Cart();
		cart.setBuyerid(this.getBuyerid());
		cart.setProdid(this.getProdid().prod_id);
		cart.setQuantity(this.getQuantity());
		return cart;
		
	}
}
