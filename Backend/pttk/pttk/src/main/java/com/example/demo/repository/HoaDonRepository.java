package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.HoaDon;

public interface HoaDonRepository extends JpaRepository<HoaDon, Long>{
	List<HoaDon> findByTrangthai_id(Long id);
	List<HoaDon> findByKhachhang_id(Long id);
}
