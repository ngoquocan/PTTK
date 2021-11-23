package com.nhom5.supermarket.service;

import java.util.List;

import com.example.demo.entity.GiaGiam;

public interface DiscountService{
	public String saveOrUpdate(GiaGiam discountEntity);

	public List<GiaGiam> findAll();

	public GiaGiam findById(Long id);

	public String deleteById(Long id);
}
