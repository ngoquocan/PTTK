package com.nhom5.supermarket.service;

import java.util.List;

import com.example.demo.entity.HoaDon;

public interface OrderService{
	public String saveOrUpdate(HoaDon orderEntity);

	public List<HoaDon> findAll();
	
	public List<HoaDon> findByCustomerId(Long id);

	public HoaDon findById(Long id);

	public String deleteById(Long id);
}
