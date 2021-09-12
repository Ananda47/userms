package com.infosys.infymarket.user.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.infosys.infymarket.user.dto.BuyerDTO;
import com.infosys.infymarket.user.dto.LoginDTO;
import com.infosys.infymarket.user.dto.ProductDTO;
import com.infosys.infymarket.user.dto.WishlistDTO;
import com.infosys.infymarket.user.entity.Buyer;
import com.infosys.infymarket.user.entity.Product;
import com.infosys.infymarket.user.entity.Wishlist;
import com.infosys.infymarket.user.repository.BuyerRepository;
import com.infosys.infymarket.user.repository.WishlistRepository;

@Service
@Transactional
public class BuyerService {
	Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    BuyerRepository buyerrepo;
    
    @Autowired
    WishlistRepository wishrepo;
    
    

    public void saveBuyer(BuyerDTO buyerDTO) {
        logger.info("Creation request for customer {} with data {}",buyerDTO);
        Buyer buyer = buyerDTO.createBuyer();
        buyerrepo.save(buyer);
    }
	public List<BuyerDTO> getAllBuyer() {

		List<Buyer> buyers = buyerrepo.findAll();
		List<BuyerDTO> buyerDTOs = new ArrayList<>();

		for (Buyer buyer : buyers) {
			BuyerDTO buyerDTO = BuyerDTO.valueOf(buyer);
			buyerDTOs.add(buyerDTO);
		}

		logger.info("Product Details : {}", buyerDTOs);
		return buyerDTOs;
	}
	public boolean login(LoginDTO loginDTO) {
		logger.info("Login request for customer {} with password {}", loginDTO.getEmail(),loginDTO.getPassword());
		Buyer buy = buyerrepo.findByEmail(loginDTO.getEmail());
		if (buy != null && buy.getPassword().equals(loginDTO.getPassword())) {
			return true;
		}
		return false;
	}
	public void deleteBuyer(String buyerid) throws Exception {
		Optional<Buyer> buyer = buyerrepo.findById(buyerid);
		buyer.orElseThrow(() -> new Exception("Service.Buyer_NOT_FOUND"));
		buyerrepo.deleteById(buyerid);
	}
	 public void createWishlist(WishlistDTO wishlistDTO) {
	        logger.info("Creation request for customer {} with data {}", wishlistDTO);
	       Wishlist wishlist = wishlistDTO.createEntity();
	       System.out.println("wishlist"+ wishlist);
	        wishrepo.save(wishlist);
	    }
	 public void deleteWish(String buyer_id) {
			Optional<Wishlist> buyer = wishrepo.findById(buyer_id);
			wishrepo.deleteById(buyer_id);
		}
	 public Buyer  updateIsprivilege(Buyer buyer, String buyer_id) {
		 Buyer existingBuyer = buyerrepo.findById(buyer_id).orElse(null);
	        if((existingBuyer != null) && (existingBuyer.getRewardpoints() >= 10000)){
	            existingBuyer.setIsprivileged(buyer.getIsprivileged());
	            return buyerrepo.save(existingBuyer); 
	           
	        }
	        return null;
	    }

}
