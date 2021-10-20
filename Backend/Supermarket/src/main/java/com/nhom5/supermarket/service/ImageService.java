package com.nhom5.supermarket.service;

import java.util.List;

import com.nhom5.supermarket.entity.ImageEntity;

public interface ImageService{
	public String saveOrUpdate(ImageEntity imageEntity);

	public List<ImageEntity> findAll();
	
	public ImageEntity findById(Long id);

	public String deleteById(Long id);
	
	public List<ImageEntity> findByProductId(Long id);
}
