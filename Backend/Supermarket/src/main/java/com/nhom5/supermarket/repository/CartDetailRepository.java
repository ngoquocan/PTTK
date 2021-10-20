package com.nhom5.supermarket.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nhom5.supermarket.entity.CartDetailEntity;

public interface CartDetailRepository extends JpaRepository<CartDetailEntity, Long>{
	List<CartDetailEntity> findByCartId(Long id);
}
