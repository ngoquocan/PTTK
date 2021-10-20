package com.nhom5.supermarket.service;

import java.util.List;

import com.nhom5.supermarket.entity.OrderDetailEntity;

public interface OrderDetailService {
	public String saveOrUpdate(OrderDetailEntity orderDetailEntity);

	public List<OrderDetailEntity> findAll();

	public OrderDetailEntity findById(Long id);

	public String deleteById(Long id);
	
	public List<OrderDetailEntity> findByOrderId(Long id);
}

