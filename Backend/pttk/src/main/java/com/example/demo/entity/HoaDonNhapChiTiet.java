package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
@Data
@Entity(name = "hoadonnhapchitiet")
public class HoaDonNhapChiTiet {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "hoadonnhap_id",referencedColumnName = "id")
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	private HoaDonNhap hoadonnhap;
	
	@ManyToOne
	@JoinColumn(name = "sanpham_id",referencedColumnName = "id")
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	private SanPham sanpham;
	
	@Column(name = "soluong")
	private Integer soluong;
	
	@Column(name = "gianhap")
	private Double gianhap;

	
	@Transient
	private Double thanhtien;
	
	public HoaDonNhapChiTiet() {
		super();
	}

	public HoaDonNhapChiTiet(SanPham sanpham) {
		super();
		this.sanpham = sanpham;
		this.gianhap = sanpham.getGianhap();
		this.soluong = 0;
	}
	
	public void setSoluong(int soluong) {
		this.soluong = soluong;
		this.thanhtien = soluong * gianhap;
	}
	public Double getThanhtien() {
		return soluong*gianhap;
	}
}
