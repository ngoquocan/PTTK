package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.KhachHang;

public interface KhachHangRepository extends JpaRepository<KhachHang, Long>{
	KhachHang findByUsername(String username);
}
