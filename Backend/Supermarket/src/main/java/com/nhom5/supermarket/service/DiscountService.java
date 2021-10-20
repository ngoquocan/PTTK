package com.nhom5.supermarket.service;

import java.util.List;

import com.nhom5.supermarket.entity.DiscountEntity;

public interface DiscountService{
	public String saveOrUpdate(DiscountEntity discountEntity);

	public List<DiscountEntity> findAll();

	public DiscountEntity findById(Long id);

	public String deleteById(Long id);
}
