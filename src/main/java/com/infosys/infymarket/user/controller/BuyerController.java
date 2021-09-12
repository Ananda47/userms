package com.infosys.infymarket.user.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.infosys.infymarket.user.dto.BuyerDTO;
import com.infosys.infymarket.user.dto.CartDTO;
import com.infosys.infymarket.user.dto.LoginDTO;
import com.infosys.infymarket.user.dto.ProductDTO;
import com.infosys.infymarket.user.dto.SellerDTO;
import com.infosys.infymarket.user.dto.WishlistDTO;
import com.infosys.infymarket.user.entity.Buyer;
import com.infosys.infymarket.user.service.BuyerService;
import com.infosys.infymarket.user.service.SellerService;

@RestController
@CrossOrigin

public class BuyerController {

	Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
    Environment environment;
	
	@Value("${product.uri}")
	String product;
  
	@Autowired
	RestTemplate restTemplate;
    @Autowired
    BuyerService buyerservice;
    @Autowired
    SellerService sellerservice;
    @PostMapping(value = "/api/buyer/register", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createBuyer(@RequestBody BuyerDTO buyerDTO) {
        logger.info("Creation request for customer {} with data {}", buyerDTO);
        buyerservice.saveBuyer(buyerDTO);
    }
	@GetMapping(value = "/api/buyers", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<BuyerDTO> getAllBuyer() {
		logger.info("Fetching all products");
		return buyerservice.getAllBuyer();
	}

	@PostMapping(value = "/buyer/login", consumes = MediaType.APPLICATION_JSON_VALUE)
	public boolean login(@RequestBody LoginDTO loginDTO) {
		logger.info("Login request for customer {} with password {}", loginDTO.getEmail(),loginDTO.getPassword());
		return buyerservice.login(loginDTO);
	}
	 @PostMapping(value = "/api/seller/register", consumes = MediaType.APPLICATION_JSON_VALUE)
	    public void createSeller(@RequestBody SellerDTO sellerDTO) {
	        logger.info("Creation request for customer {} with data {}", sellerDTO);
	        sellerservice.saveSeller(sellerDTO);
	    }
		@GetMapping(value = "/api/sellers", produces = MediaType.APPLICATION_JSON_VALUE)
		public List<SellerDTO> getAllSeller() {
			logger.info("Fetching all products");
			return sellerservice.getAllSeller();
		}

		@PostMapping(value = "/seller/login", consumes = MediaType.APPLICATION_JSON_VALUE)
		public boolean Login(@RequestBody LoginDTO loginDTO) {
			logger.info("Login request for customer {} with password {}", loginDTO.getEmail(),loginDTO.getPassword());
			return sellerservice.login(loginDTO);
		}
		@DeleteMapping(value = "/buyer/{buyer_id}")
		public ResponseEntity<String> deleteBuyer(@PathVariable String buyer_id) throws Exception {
			buyerservice.deleteBuyer(buyer_id);
			String successMessage = environment.getProperty("API.DELETE_SUCCESS");
			return new ResponseEntity<>(successMessage, HttpStatus.OK);
		}
		@DeleteMapping(value = "/seller/{seller_id}")
		public ResponseEntity<String> deleteSeller(@PathVariable String seller_id) throws Exception {
			sellerservice.deleteSeller(seller_id);
			String successMessage = environment.getProperty("API.DELETE_SUCCESS");
			return new ResponseEntity<>(successMessage, HttpStatus.OK);
		}
		@PostMapping(value = "/api/wishlist/add", consumes = MediaType.APPLICATION_JSON_VALUE)
	    public void saveWishlist( @RequestBody WishlistDTO wishlistDTO) {
	        logger.info("Creation request for customer {} with data {}", wishlistDTO);
	        Map<String,Object> map = new HashMap<String,Object>();
	        map.put("prod_id",wishlistDTO.getProdid().getProdid());
	       // map.put("buyer_id",wishlistDTO.getBuyerid());
	        System.out.println("adding map"+ map);
	        ProductDTO obj = restTemplate.getForObject("http://localhost:8100/api/verifyprod/{prod_id}", ProductDTO.class,map );
	       System.out.println("adding wishlist"+ obj);
	        buyerservice.createWishlist(wishlistDTO);
		}
		@DeleteMapping(value = "/wishlist/{buyer_id}")
		public String deleteWishlist(@PathVariable String buyer_id) {
				buyerservice.deleteWish(buyer_id);
			    return "success";
			
		}
		@PostMapping(value = "/api/cart/add", consumes = MediaType.APPLICATION_JSON_VALUE)
	    public void saveCart( @RequestBody CartDTO cartDTO) {
	        logger.info("Creation request for customer {} with data {}", cartDTO);
	        Map<String,Object> map = new HashMap<String,Object>();
	        map.put("prodid",cartDTO.getProdid().getProdid());
	       // map.put("buyer_id",wishlistDTO.getBuyerid());
	        System.out.println("adding map"+ map);
	        ProductDTO cart = restTemplate.getForObject("http://localhost:8100/api/verifyprod/{prod_id}", ProductDTO.class,map );
	       System.out.println("adding cart"+ cart);
	       sellerservice.createCart(cartDTO);
		}
		@DeleteMapping(value = "/cart/{buyer_id}")
		public String deleteCart(@PathVariable String buyer_id) {
			sellerservice.deleteCart(buyer_id);
			    return "success";
		}
		@RequestMapping(value = "/api/is_privilege/{buyer_id}", method = RequestMethod.PUT)
	    public Buyer updateIsprivilege(@RequestBody Buyer buyer, @PathVariable String buyer_id) {
	        return buyerservice.updateIsprivilege(buyer, buyer_id);
	    }

}
 

