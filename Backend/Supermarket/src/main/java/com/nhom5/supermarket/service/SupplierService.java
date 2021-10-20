package com.nhom5.supermarket.service;

import java.util.List;

import com.nhom5.supermarket.entity.SupplierEntity;

public interface SupplierService{
	public String saveOrUpdate(SupplierEntity supplierEntity);

	public List<SupplierEntity> findAll();

	public SupplierEntity findById(Long id);

	public String deleteById(Long id);
}
