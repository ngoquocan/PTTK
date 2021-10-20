package com.nhom5.supermarket.service;

import java.util.List;

import com.nhom5.supermarket.entity.EmployeeEntity;

public interface EmployeeService{
	public String saveOrUpdate(EmployeeEntity employeeEntity);

	public List<EmployeeEntity> findAll();

	public EmployeeEntity findById(Long id);

	public String deleteById(Long id);
}
