package com.nhom5.supermarket.service;

import java.util.List;

import com.nhom5.supermarket.entity.NhanVien;

public interface EmployeeService{
	public String saveOrUpdate(NhanVien employeeEntity);

	public List<NhanVien> findAll();

	public NhanVien findById(Long id);

	public String deleteById(Long id);
}
