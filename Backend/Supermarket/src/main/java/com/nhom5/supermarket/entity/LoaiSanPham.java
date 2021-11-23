package com.nhom5.supermarket.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity(name = "loaisanpham")
@Data
public class LoaiSanPham {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "tenloai")
	private String tenloai;
	
//	@OneToMany(mappedBy = "productType")
//	@EqualsAndHashCode.Exclude
//    @ToString.Exclude
//	private List<SanPham> listProduct;
}
