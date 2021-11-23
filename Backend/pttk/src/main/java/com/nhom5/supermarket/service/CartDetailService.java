package com.nhom5.supermarket.service;

import java.util.List;

import com.example.demo.entity.GioHangChiTiet;

public interface CartDetailService {
	public String saveOrUpdate(GioHangChiTiet cartDetailEntity);

	public List<GioHangChiTiet> findAll();

	public GioHangChiTiet findById(Long id);

	public String deleteById(Long id);
	
	public List<GioHangChiTiet> findByCartId(Long id);
}
