package com.example.demo.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.HoaDonChiTiet;

public interface HoaDonChiTietRepository extends JpaRepository<HoaDonChiTiet, Long>{

	@Query(value = "SELECT sp.id, sp.ten as tensp, ncc.ten as tenncc,sum(hdct.soluong) AS soluong, sum(hdct.giaban*hdct.soluong) AS tongtien "
			+ "FROM hoadonchitiet hdct JOIN hoadon hd ON hdct.hoadon_id = hd.id "
					+ "JOIN sanpham sp ON sp.id = hdct.sanpham "
					+ "JOIN nhacungcap ncc ON sp.nhacungcap_id = ncc.id "
			+ "WHERE hd.trangthai_id=1 AND hd.ngaydat >= ?1 AND hd.ngaydat <= ?2 "
			+ "GROUP BY hdct.sanpham "
			+ "ORDER BY tongtien DESC",nativeQuery = true)
	List<Object[]> thongKeSanPhamTheoDoanhThu(Date start,Date end);
}
