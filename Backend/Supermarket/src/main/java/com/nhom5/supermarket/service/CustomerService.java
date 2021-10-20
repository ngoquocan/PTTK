package com.nhom5.supermarket.service;

import java.util.List;

import com.nhom5.supermarket.entity.CustomerEntity;

public interface CustomerService{
	public String saveOrUpdate(CustomerEntity customerEntity);

	public List<CustomerEntity> findAll();

	public CustomerEntity findById(Long id);

	public String deleteById(Long id);
}
