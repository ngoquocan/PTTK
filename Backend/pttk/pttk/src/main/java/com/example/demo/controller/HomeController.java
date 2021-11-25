package com.example.demo.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.LoaiSanPham;
import com.example.demo.entity.NguoiDung;
import com.example.demo.entity.SanPham;
import com.example.demo.repository.KhachHangRepository;
import com.example.demo.repository.LoaiSanPhamRepository;
import com.example.demo.repository.NhanVienRepository;
import com.example.demo.repository.SanPhamRepository;

@Controller
@RequestMapping("/")
@Transactional(rollbackFor = {Exception.class, Throwable.class})
public class HomeController {

	@Autowired
	private NhanVienRepository nhanVienRepository;
	@Autowired
	private KhachHangRepository khachHangRepository;
	@Autowired
	private SanPhamRepository sanPhamRepository;
	@Autowired
	private LoaiSanPhamRepository loaiSanPhamRepository;

	@GetMapping(value={"/","dangnhap"})
	public String dangnhap() {
		return "dangnhap";
	}
	@GetMapping("/dangnhapnhanvien")
	public String dangnhapnhanvien() {
		return "dangnhapnhanvien";
	}
	
	@PostMapping("khachhang/trangchu")
	public String trangchu(HttpSession session, ModelMap modelMap, @RequestParam(name = "username") String username,
			@RequestParam(name = "password") String password) {
		NguoiDung nguoiDung = khachHangRepository.findByUsername(username);
		if(nguoiDung != null) {
			if(nguoiDung.getPassword().equals(password)) {
				List<SanPham> listSanPham = sanPhamRepository.findAll();
				List<LoaiSanPham> listLoaiSanPham = loaiSanPhamRepository.findAll();
				session.setAttribute("listsanpham", listSanPham);
				session.setAttribute("khachhang", nguoiDung);
				modelMap.addAttribute("listloaisanpham", listLoaiSanPham);
				modelMap.addAttribute("listsanpham", listSanPham);
				return "khachhang/trangchu";
			}
		}
		return "dangnhap";
	}
	@PostMapping("nhanvien/trangchu")
	public String trangchunhavien(HttpSession session, ModelMap modelMap, @RequestParam(name = "username") String username,
			@RequestParam(name = "password") String password) {
		NguoiDung nguoiDung = nhanVienRepository.findByUsername(username);
		if(nguoiDung != null) {
			if(nguoiDung.getPassword().equals(password) && nguoiDung.getRole().getId()==1) {
				session.setAttribute("quanly", nguoiDung);
				return "quanly/trangchu";
			}
			else if(nguoiDung.getPassword().equals(password) && nguoiDung.getRole().getId()==2) {
				session.setAttribute("nhanvienkho", nguoiDung);
				return "nhanvienkho/trangchu";
			}
		}
		return "dangnhapnhanvien";
	}

}
