package com.nhom5.supermarket.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity(name = "nhacungcap")
@Data
public class NhaCungCap {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "ten")
	private String ten;	
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "sdt")
	private String sdt;
	
	@OneToOne
	@JoinColumn(name = "diachi_id")
	private DiaChi diachi;
	
//	@OneToMany(mappedBy = "supplier")
//	@EqualsAndHashCode.Exclude
//    @ToString.Exclude
//	private List<SanPham> listProduct;
}
