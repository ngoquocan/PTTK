package com.nhom5.supermarket.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.EqualsAndHashCode;
import lombok.ToString;

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
}
