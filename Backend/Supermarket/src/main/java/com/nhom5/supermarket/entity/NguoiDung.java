package com.nhom5.supermarket.entity;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Data;

@Data
@MappedSuperclass
public abstract class NguoiDung {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "username")
	private String username;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "hoten")
	private String hoten;
	
	@Column(name = "ngaysinh")
	private Date ngaysinh;
	
	@Column(name = "gioitinh")
	private String gioitinh;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "sdt")
	private String sdt;
	
	@OneToOne
	@JoinColumn(name = "address_id")
	private DiaChi address;
	
	@OneToOne
	@JoinColumn(name = "role_id")
	private Role role;
}
