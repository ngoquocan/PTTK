package com.nhom5.supermarket.service;

import java.util.List;

import com.nhom5.supermarket.entity.GioHang;

public interface CartService{
	public String saveOrUpdate(GioHang cartEntity);

	public List<GioHang> findAll();

	public GioHang findById(Long id);
	
	public GioHang findByCustomerId(Long id);

	public String deleteById(Long id);
}
