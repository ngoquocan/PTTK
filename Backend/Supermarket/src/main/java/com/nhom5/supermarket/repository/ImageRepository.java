package com.nhom5.supermarket.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nhom5.supermarket.entity.ImageEntity;

public interface ImageRepository extends JpaRepository<ImageEntity, Long>{
	List<ImageEntity> findByProductId(Long id);
}
