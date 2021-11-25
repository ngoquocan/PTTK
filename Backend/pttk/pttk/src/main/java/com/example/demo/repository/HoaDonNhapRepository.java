package com.example.demo.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.HoaDonNhap;

public interface HoaDonNhapRepository extends JpaRepository<HoaDonNhap, Long> {
	
	@Query(value = "SELECT * FROM hoadonnhap "
			+ "WHERE nhacungcap_id = ?1 AND ngaynhap >= " + "?2" + " AND ngaynhap <= " + "?3",nativeQuery = true)
	List<HoaDonNhap> findByNhacungcap(Long id,Date start, Date end);
}
