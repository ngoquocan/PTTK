package com.nhom5.supermarket.service;

import java.util.List;

import com.example.demo.entity.KhachHang;

public interface CustomerService{
	public String saveOrUpdate(KhachHang customerEntity);

	public List<KhachHang> findAll();

	public KhachHang findById(Long id);

	public String deleteById(Long id);
}
