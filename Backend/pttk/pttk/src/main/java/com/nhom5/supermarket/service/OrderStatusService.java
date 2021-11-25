package com.nhom5.supermarket.service;

import java.util.List;

import com.example.demo.entity.TrangThai;

public interface OrderStatusService{
	public String saveOrUpdate(TrangThai orderStatusEntity);

	public List<TrangThai> findAll();

	public TrangThai findById(Long id);

	public String deleteById(Long id);
}
