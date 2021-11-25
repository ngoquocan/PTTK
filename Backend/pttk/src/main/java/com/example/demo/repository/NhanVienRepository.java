package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.NhanVien;

public interface NhanVienRepository extends JpaRepository<NhanVien, Long>{
	NhanVien findByUsername(String username);
}
