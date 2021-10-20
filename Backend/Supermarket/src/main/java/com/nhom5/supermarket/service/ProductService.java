package com.nhom5.supermarket.service;

import java.util.List;

import com.nhom5.supermarket.entity.ProductEntity;

public interface ProductService{
	public String saveOrUpdate(ProductEntity productEntity);

	public List<ProductEntity> findAll();

	public ProductEntity findById(Long id);

	public String deleteById(Long id);
}
