package com.nhom5.supermarket.service;

import java.util.List;

import com.nhom5.supermarket.entity.CartEntity;

public interface CartService{
	public String saveOrUpdate(CartEntity cartEntity);

	public List<CartEntity> findAll();

	public CartEntity findById(Long id);
	
	public CartEntity findByCustomerId(Long id);

	public String deleteById(Long id);
}
