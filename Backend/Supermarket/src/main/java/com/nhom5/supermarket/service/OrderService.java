package com.nhom5.supermarket.service;

import java.util.List;

import com.nhom5.supermarket.entity.OrderEntity;

public interface OrderService{
	public String saveOrUpdate(OrderEntity orderEntity);

	public List<OrderEntity> findAll();
	
	public List<OrderEntity> findByCustomerId(Long id);

	public OrderEntity findById(Long id);

	public String deleteById(Long id);
}
