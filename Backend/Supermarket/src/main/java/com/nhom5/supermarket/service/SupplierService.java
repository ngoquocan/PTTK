package com.nhom5.supermarket.service;

import java.util.List;

import com.nhom5.supermarket.entity.NhaCungCap;

public interface SupplierService{
	public String saveOrUpdate(NhaCungCap supplierEntity);

	public List<NhaCungCap> findAll();

	public NhaCungCap findById(Long id);

	public String deleteById(Long id);
}
