package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.GioHang;

public interface GioHangRepository extends JpaRepository<GioHang, Long>{

	GioHang findByKhachhang_id(Long id);
	
	
}
