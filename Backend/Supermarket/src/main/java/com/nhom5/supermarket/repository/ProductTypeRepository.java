package com.nhom5.supermarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nhom5.supermarket.entity.ProductTypeEntity;

public interface ProductTypeRepository extends JpaRepository<ProductTypeEntity, Long>{

}
