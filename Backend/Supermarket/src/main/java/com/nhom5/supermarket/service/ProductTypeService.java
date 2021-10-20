package com.nhom5.supermarket.service;

import java.util.List;

import com.nhom5.supermarket.entity.ProductTypeEntity;

public interface ProductTypeService{
	public String saveOrUpdate(ProductTypeEntity productTypeEntity);

	public List<ProductTypeEntity> findAll();

	public ProductTypeEntity findById(Long id);

	public String deleteById(Long id);
}
