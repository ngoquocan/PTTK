package com.nhom5.supermarket.service;

import java.util.List;

import com.nhom5.supermarket.entity.SanPham;

public interface ProductService{
	public String saveOrUpdate(SanPham productEntity);

	public List<SanPham> findAll();

	public SanPham findById(Long id);

	public String deleteById(Long id);
}
