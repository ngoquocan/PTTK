package com.nhom5.supermarket.service;

import java.util.List;

import com.nhom5.supermarket.entity.AddressEntity;

public interface AddressService{
	public String saveOrUpdate(AddressEntity addressEntity);

	public List<AddressEntity> findAll();

	public AddressEntity findById(Long id);

	public String deleteById(Long id);
	
}
