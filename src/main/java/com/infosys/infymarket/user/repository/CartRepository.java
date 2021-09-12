package com.infosys.infymarket.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infosys.infymarket.user.entity.Cart;

public interface CartRepository extends JpaRepository<Cart, String> {

    

}
