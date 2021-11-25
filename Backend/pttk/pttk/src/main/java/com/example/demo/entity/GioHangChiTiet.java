package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonValue;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity(name = "giohangchitiet")
@Data
public class GioHangChiTiet {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "giohang_id",referencedColumnName = "id")
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@JsonIgnore
	private GioHang giohang;
	
	@ManyToOne
	@JoinColumn(name = "sanpham_id",referencedColumnName = "id")
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	private SanPham sanpham;
	
	@Column(name = "soluong")
	private Integer soluong;
	
	@Transient
	private Double thanhtien;

	public GioHangChiTiet(GioHang giohang, SanPham sanpham,int soluong) {
		super();
		this.giohang = giohang;
		this.sanpham = sanpham;
		this.soluong = soluong;
		this.thanhtien = soluong * sanpham.getGiaban();
	}

	public GioHangChiTiet() {
		super();
	}
	public Double getThanhtien() {
		return soluong * sanpham.getGiaban();
	}
}
