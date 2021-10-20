package com.nhom5.supermarket.service;

import java.util.List;

import com.nhom5.supermarket.entity.OrderStatusEntity;

public interface OrderStatusService{
	public String saveOrUpdate(OrderStatusEntity orderStatusEntity);

	public List<OrderStatusEntity> findAll();

	public OrderStatusEntity findById(Long id);

	public String deleteById(Long id);
}
