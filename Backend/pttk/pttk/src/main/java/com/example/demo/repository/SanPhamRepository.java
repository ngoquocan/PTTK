package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.SanPham;

public interface SanPhamRepository extends JpaRepository<SanPham, Long>{
	@Query(value = "SELECT * FROM supermarket.sanpham WHERE sanpham.nhacungcap_id = ?1 ORDER BY id LIMIT 10", nativeQuery = true)
	List<SanPham> getListSanPham(Long id);
	
	//@Query(value = "SELECT * FROM supermarket.sanpham WHERE nhacungcap_id = ?1 AND ten LIKE '%" + "?2" + "%'", nativeQuery =true)
	List<SanPham> findByNhacungcap_idAndTenContaining(Long idNCC,String data);
	List<SanPham> findByTenContaining(String data);
}