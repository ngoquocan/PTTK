package com.nhom5.supermarket.service;

import java.util.List;

import com.nhom5.supermarket.entity.OrderExportEntity;

public interface OrderExportService{
	public String saveOrUpdate(OrderExportEntity orderExportEntity);

	public List<OrderExportEntity> findAll();

	public OrderExportEntity findById(Long id);

	public String deleteById(Long id);
}
