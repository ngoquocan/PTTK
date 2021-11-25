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

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity(name = "hoadonchitiet")
@Data
public class HoaDonChiTiet {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "hoadon_id",referencedColumnName = "id")
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@JsonIgnore
	private HoaDon hoadon;
	
	@ManyToOne
	@JoinColumn(name = "sanpham",referencedColumnName = "id")
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	private SanPham sanpham;
	
	@Column(name = "giaban")
	private Double giaban;
	
	@ManyToOne
	@JoinColumn(name = "giagiam_id")
	private GiaGiam giagiam;
	
	@Column(name = "soluong")
	private Integer soluong;

	@Transient
	private Double thanhtien;
	
	public void setSoluong(int soluong) {
		this.soluong = soluong;
		this.thanhtien = soluong * giaban;
	}
	public Double getThanhtien() {
		return soluong * giaban;
	}
}
