package com.nhom5.supermarket.service;

import java.util.List;

import com.example.demo.entity.HoaDonNhap;

public interface OrderExportService{
	public String saveOrUpdate(HoaDonNhap orderExportEntity);

	public List<HoaDonNhap> findAll();

	public HoaDonNhap findById(Long id);

	public String deleteById(Long id);
}
