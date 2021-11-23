package com.nhom5.supermarket.service;

import java.util.List;

import com.nhom5.supermarket.entity.LoaiSanPham;

public interface ProductTypeService{
	public String saveOrUpdate(LoaiSanPham productTypeEntity);

	public List<LoaiSanPham> findAll();

	public LoaiSanPham findById(Long id);

	public String deleteById(Long id);
}
