package com.nhom5.supermarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nhom5.supermarket.entity.OrderExportEntity;

public interface OrderExportRepository extends JpaRepository<OrderExportEntity, Long>{

}
