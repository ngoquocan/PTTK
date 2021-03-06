package com.nhom5.supermarket.service;

import java.util.List;

import com.example.demo.entity.DiaChi;

public interface AddressService{
	public String saveOrUpdate(DiaChi addressEntity);

	public List<DiaChi> findAll();

	public DiaChi findById(Long id);

	public String deleteById(Long id);
	
}
