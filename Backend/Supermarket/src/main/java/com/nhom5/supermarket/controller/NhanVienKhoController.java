package com.nhom5.supermarket.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/nhanvienkho")
public class NhanVienKhoController {
	@GetMapping("/themNhaCungCap")
	public String gdchinhgoitrangchuadmin() {
		return "nhanvienkho/themNhaCungCap";
	}
}
