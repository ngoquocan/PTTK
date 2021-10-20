package com.nhom5.supermarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nhom5.supermarket.entity.OrderStatusEntity;

public interface OrderStatusRepository extends JpaRepository<OrderStatusEntity, Long>{

}
