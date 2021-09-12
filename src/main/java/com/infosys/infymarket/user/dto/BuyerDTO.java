package com.infosys.infymarket.user.dto;



import com.infosys.infymarket.user.entity.Buyer;


public class BuyerDTO {
    
	
	String buyer_id;
	String name;
	String email;
	String phone_number;
	String password;
	String is_active;
	String is_privileged;
	Integer rewardpoints;


	

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
	

		@Override
	public String toString() {
		return "BuyerDTO [buyer_id=" + buyer_id + ", name=" + name + ", email=" + email + ", phone_number=" + phone_number
				+ ", password=" + password + ", is_active=" + is_active + ", is_privileged=" + is_privileged
				+ ", rewardpoints=" + rewardpoints + "]";
	}

		// Converts Entity into DTO
		public static BuyerDTO valueOf(Buyer buyer) {
			BuyerDTO buyerDTO = new BuyerDTO();
			buyerDTO.setBuyerid(buyer.getBuyerid());
			buyerDTO.setName(buyer.getName());
			buyerDTO.setEmail(buyer.getEmail());
			buyerDTO.setPhoneno(buyer.getPhoneno());
			buyerDTO.setPassword(buyer.getPassword());
			buyerDTO.setIsactive(buyer.getIsactive());
			buyerDTO.setIsprivileged(buyer.getIsprivileged());
			buyerDTO.setRewardpoints(buyer.getRewardpoints());
			return buyerDTO;
		}
		public Buyer createBuyer() {
            Buyer buyer = new Buyer();
            buyer.setBuyerid(this.getBuyerid());
            buyer.setName(this.getName());
            buyer.setPhoneno(this.getPhoneno());
            buyer.setEmail(this.getEmail());
            buyer.setPassword(this.getPassword());
            buyer.setIsprivileged(this.getIsprivileged());
            buyer.setRewardpoints(this.getRewardpoints());
            buyer.setIsactive(this.getIsactive());
            return buyer;
        }

}
