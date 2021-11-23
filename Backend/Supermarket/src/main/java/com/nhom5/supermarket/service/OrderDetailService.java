package com.nhom5.supermarket.service;

import java.util.List;

import com.nhom5.supermarket.entity.HoaDonChiTiet;

public interface OrderDetailService {
	public String saveOrUpdate(HoaDonChiTiet orderDetailEntity);

	public List<HoaDonChiTiet> findAll();

	public HoaDonChiTiet findById(Long id);

	public String deleteById(Long id);
	
	public List<HoaDonChiTiet> findByOrderId(Long id);
}

