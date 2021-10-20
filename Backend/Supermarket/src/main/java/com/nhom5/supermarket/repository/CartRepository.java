package com.nhom5.supermarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nhom5.supermarket.entity.CartEntity;

public interface CartRepository extends JpaRepository<CartEntity, Long>{
	CartEntity findByCustomerId(Long id);
}
