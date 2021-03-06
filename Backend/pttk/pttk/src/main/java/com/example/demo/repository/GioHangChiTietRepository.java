package com.example.demo.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.GioHangChiTiet;

public interface GioHangChiTietRepository extends JpaRepository<GioHangChiTiet, Long>{
	@Modifying
    @Transactional
	@Query(value = "DELETE FROM supermarket.giohangchitiet WHERE giohang_id = ?1", nativeQuery = true)
	void deleteByGiohang_id(Long id);
}
