package com.example.demo.entity;

import lombok.Data;

@Data
public class ThongKeSanPham {
	private Long id;
	private String tensanpham;
	private String tennhacungcap;
	private int soluong;
	private Double tongtien;
}
