package com.nhom5.supermarket.service;

import java.util.List;

import com.example.demo.entity.Anh;

public interface ImageService{
	public String saveOrUpdate(Anh imageEntity);

	public List<Anh> findAll();
	
	public Anh findById(Long id);

	public String deleteById(Long id);
	
	public List<Anh> findByProductId(Long id);
}
