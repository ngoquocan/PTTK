package com.nhom5.supermarket.service;

import java.util.List;

import com.nhom5.supermarket.entity.CartDetailEntity;

public interface CartDetailService {
	public String saveOrUpdate(CartDetailEntity cartDetailEntity);

	public List<CartDetailEntity> findAll();

	public CartDetailEntity findById(Long id);

	public String deleteById(Long id);
	
	public List<CartDetailEntity> findByCartId(Long id);
}
