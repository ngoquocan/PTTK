package com.nhom5.supermarket.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nhom5.supermarket.entity.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, Long>{
//	tìm bản ghi mơi nhất
	ProductEntity findFirstByOrderByIdDesc();
	
	List<ProductEntity> findTop5ByOrderByIdDesc();
}
