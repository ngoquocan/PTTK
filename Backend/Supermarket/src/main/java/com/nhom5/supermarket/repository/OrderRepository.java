package com.nhom5.supermarket.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nhom5.supermarket.entity.OrderEntity;

public interface OrderRepository extends JpaRepository<OrderEntity, Long>{
	
	List<OrderEntity> findByCustomerId(Long id);
	
	OrderEntity findFirstByOrderByIdDesc();
}
