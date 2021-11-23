package com.nhom5.supermarket.service;

import java.util.List;

import com.nhom5.supermarket.entity.HoaDonNhap;

public interface OrderExportService{
	public String saveOrUpdate(HoaDonNhap orderExportEntity);

	public List<HoaDonNhap> findAll();

	public HoaDonNhap findById(Long id);

	public String deleteById(Long id);
}
