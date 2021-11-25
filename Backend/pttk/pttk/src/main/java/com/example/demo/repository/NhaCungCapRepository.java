package com.example.demo.repository;

import java.util.Date;
import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.NhaCungCap;
import com.example.demo.entity.ThongKeNhaCungCap;

public interface NhaCungCapRepository extends JpaRepository<NhaCungCap, Long>{
	@Query(value = "SELECT ncc.id, ncc.ten , sum(tongtien) as tongtien "
			+ "FROM nhacungcap ncc JOIN hoadonnhap hdn ON ncc.id = hdn.nhacungcap_id "
			+ "WHERE hdn.ngaynhap >= ?1 AND hdn.ngaynhap <= ?2 "
			+ "GROUP BY nhacungcap_id "
			+ "ORDER BY tongtien DESC "
			+ "LIMIT 10", nativeQuery = true)
	List<Object[]> getTop10NCC(Date start, Date end);
}
