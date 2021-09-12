package com.infosys.infymarket.user.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.infosys.infymarket.user.dto.CartDTO;
import com.infosys.infymarket.user.dto.LoginDTO;
import com.infosys.infymarket.user.dto.SellerDTO;
import com.infosys.infymarket.user.entity.Cart;
import com.infosys.infymarket.user.entity.Seller;
import com.infosys.infymarket.user.repository.CartRepository;
import com.infosys.infymarket.user.repository.SellerRepository;

@Service
@Transactional
public class SellerService {
	Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    SellerRepository sellerrepo;
    
    @Autowired
    CartRepository cartRepo;
    
    

    public void saveSeller(SellerDTO sellerDTO) {
        logger.info("Creation request for customer {} with data {}",sellerDTO);
        Seller seller = sellerDTO.createSeller();
        sellerrepo.save(seller);
    }
	public List<SellerDTO> getAllSeller() {
		List<Seller> sellers = sellerrepo.findAll();
		List<SellerDTO> sellerDTOs = new ArrayList<>();
		for (Seller seller : sellers) {
			SellerDTO sellerDTO = SellerDTO.valueOf(seller);
			sellerDTOs.add(sellerDTO);
		}
		logger.info("Product Details : {}", sellerDTOs);
		return sellerDTOs;
	}
	public boolean login(LoginDTO loginDTO) {
		logger.info("Login request for customer {} with password {}", loginDTO.getEmail(),loginDTO.getPassword());
		Seller sell = sellerrepo.findByEmail(loginDTO.getEmail());
		if (sell != null && sell.getPassword().equals(loginDTO.getPassword())) {
			return true;
		}
		return false;
	}
	public void deleteSeller(String seller_id) throws Exception {
		Optional<Seller> seller = sellerrepo.findById(seller_id);
		seller.orElseThrow(() -> new Exception("Service.Seller_NOT_FOUND"));
		sellerrepo.deleteById(seller_id);
	}
	public void createCart(CartDTO cartDTO) {
        logger.info("Creation request for customer {} with data {}", cartDTO);
       Cart cart = cartDTO.createEntity();
       System.out.println("wishlist"+ cart);
        cartRepo.save(cart);
    }
 public void deleteCart(String buyer_id) {
		Optional<Cart> cart = cartRepo.findById(buyer_id);
		cartRepo.deleteById(buyer_id);
	}
	
}
