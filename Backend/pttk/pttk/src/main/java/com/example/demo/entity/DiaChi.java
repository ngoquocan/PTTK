package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity(name = "diachi")
public class DiaChi {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
	
	
	@Column(name = "thanhpho")
	private String thanhpho;
	
	@Column(name = "quan")
	private String quan;
	
	@Column(name = "phuong")
	private String phuong;
	
	@Column(name = "mota")
	private String mota;
	

}
