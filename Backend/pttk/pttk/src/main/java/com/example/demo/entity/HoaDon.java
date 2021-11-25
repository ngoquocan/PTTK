package com.example.demo.entity;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity(name = "hoadon")
@Data
public class HoaDon{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "tongtien")
	private Double tongtien;
	
	@Column(name = "ngaydat")
	private Timestamp ngaydat;
	
	@Column(name = "ngayxuat")
	private Timestamp ngayxuat;
	
	@ManyToOne
	@JoinColumn(name = "khachhang_id", referencedColumnName = "id")
	private KhachHang khachhang;
	
	@ManyToOne
	@JoinColumn(name = "nhanvien_id")
	private NhanVien nhanvien;
	
	@ManyToOne
	@JoinColumn(name = "trangthai_id", referencedColumnName = "id")
	private TrangThai trangthai;
	
	@OneToMany(mappedBy = "hoadon", fetch = FetchType.EAGER)
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	private List<HoaDonChiTiet> listhoadon;

	public HoaDon(Double tongtien, Timestamp ngaydat, KhachHang khachhang,
			NhanVien nhanvien, TrangThai trangthai) {
		super();
		this.tongtien = tongtien;
		this.ngaydat = ngaydat;
		this.khachhang = khachhang;
		this.nhanvien = nhanvien;
		this.trangthai = trangthai;
	}

	public HoaDon() {
		super();
	}
		
}
