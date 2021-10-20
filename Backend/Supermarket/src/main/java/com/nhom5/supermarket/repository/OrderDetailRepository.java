package com.nhom5.supermarket.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nhom5.supermarket.entity.OrderDetailEntity;

public interface OrderDetailRepository extends JpaRepository<OrderDetailEntity, Long> {
	List<OrderDetailEntity> findByOrderId(Long id);
}
