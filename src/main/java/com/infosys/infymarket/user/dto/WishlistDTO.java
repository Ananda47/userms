package com.infosys.infymarket.user.dto;

import com.infosys.infymarket.user.entity.Wishlist;

public class WishlistDTO {
	
	String buyer_id;
	ProductDTO prod_id;
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
	@Override
	public String toString() {
		return "WishlistDTO [buyer_id=" + buyer_id + ", prod_id=" + prod_id + "]";
	}
	public static WishlistDTO valueOf(Wishlist wishlist) {
		WishlistDTO wishlistDTO = new WishlistDTO();
		wishlistDTO.setBuyerid(wishlist.getBuyerid());
		ProductDTO productDTO = new ProductDTO();
		productDTO.setProdid(wishlist.getProdid());
    return wishlistDTO;
	}
	public Wishlist createEntity() {
		Wishlist wish = new Wishlist();
		wish.setBuyerid(this.getBuyerid());
		wish.setProdid(this.getProdid().prod_id);
		return wish;
		
	}
}
