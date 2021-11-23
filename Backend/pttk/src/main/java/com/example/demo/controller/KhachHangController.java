package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.DiaChi;
import com.example.demo.entity.GioHang;
import com.example.demo.entity.GioHangChiTiet;
import com.example.demo.entity.HoaDon;
import com.example.demo.entity.HoaDonChiTiet;
import com.example.demo.entity.HoaDonNhapChiTiet;
import com.example.demo.entity.KhachHang;
import com.example.demo.entity.NhaCungCap;
import com.example.demo.entity.Role;
import com.example.demo.entity.SanPham;
import com.example.demo.entity.TrangThai;
import com.example.demo.repository.DiaChiRepository;
import com.example.demo.repository.GioHangChiTietRepository;
import com.example.demo.repository.GioHangRepository;
import com.example.demo.repository.HoaDonChiTietRepository;
import com.example.demo.repository.HoaDonRepository;
import com.example.demo.repository.KhachHangRepository;
import com.example.demo.repository.SanPhamRepository;

@Controller
@RequestMapping("/khachhang")
public class KhachHangController {
	
	@Autowired
	private KhachHangRepository khachHangRepository;	
	@Autowired
	private DiaChiRepository diaChiRepository;
	@Autowired
	private SanPhamRepository sanPhamRepository;
	@Autowired
	private GioHangRepository gioHangRepository;
	@Autowired
	private GioHangChiTietRepository gioHangChiTietRepository;
	@Autowired
	private HoaDonRepository hoaDonRepository;
	@Autowired
	private HoaDonChiTietRepository hoaDonChiTietRepository;
	
	public String dangnhap() {
		return null;
	}
	
	@GetMapping("/dangky")
	public String dangky(ModelMap modelMap) {
		modelMap.addAttribute("khachhang", new KhachHang());
		return "khachhang/dangky";
	}
	
	@PostMapping("/luu")
	public String luu(ModelMap modelMap,KhachHang khachHang) {
		DiaChi diachi = diaChiRepository.save(khachHang.getDiachi());
		khachHang.setDiachi(diachi);
		khachHang.setRole(new Role((long) 3,"KHACHHANG"));
		khachHangRepository.save(khachHang);
		return "dangnhap";
	}
	
	@GetMapping("/trangchu")
	public String trangchu(HttpSession session,ModelMap modelMap) {
		List<SanPham> listSanPham = sanPhamRepository.findAll();
		session.setAttribute("listsanpham", listSanPham);
		modelMap.addAttribute("listsanpham", listSanPham);
		return "khachhang/trangchu";
		
	}
	@GetMapping("/timkiem")
	public String timsanpham(ModelMap modelMap,HttpSession session, @RequestParam(name = "data") String data) {
		List<SanPham> listSanPham = sanPhamRepository.findByTenContaining(data);
		modelMap.addAttribute("listsanpham", listSanPham);
		session.setAttribute("listsanpham", listSanPham);
		return "khachhang/trangchu";
	}
	@SuppressWarnings("unchecked")
	@GetMapping("/chitietsanpham")
	public String chitietsanpham(ModelMap modelMap,HttpSession session, @RequestParam(name = "index") int index) {
		
		//chon sản phẩm
		SanPham sanpham = ((List<SanPham>)session.getAttribute("listsanpham")).get(index);
		
		modelMap.addAttribute("sanpham",sanpham);
		session.setAttribute("sanpham",sanpham);
		
		return "khachhang/chitietsanpham";
	}
	
	@RequestMapping("/giohang")
	public String xemgiohang(HttpSession session,ModelMap modelMap) {
		//tìm giỏ hàng theo id khách hàng
		GioHang giohang = gioHangRepository.findByKhachhang_id((long)1);		
		List<GioHangChiTiet> listGHCT = giohang.getListGHCT();
		
		//tính tổng tiền
		Double tongtien = (double) 0;
		for(GioHangChiTiet item : listGHCT) {
			tongtien += item.getThanhtien();
		}	
		modelMap.addAttribute("listGHCT", listGHCT);
		modelMap.addAttribute("tongtien", tongtien);
		session.setAttribute("listGHCT", listGHCT);
		return "khachhang/giohang";
	}
	
	@RequestMapping("/themgiohang")
	public String themvaogiohang(HttpSession session,ModelMap modelMap,
			@RequestParam(name = "soluong") int soluong) {
		//tìm giỏ hàng theo id khách hàng
		GioHang giohang = gioHangRepository.findByKhachhang_id((long)1);		
		List<GioHangChiTiet> listGHCT = giohang.getListGHCT();
		
		//them sản phẩm vào giỏ hàng
		SanPham sanpham = (SanPham)session.getAttribute("sanpham");
		GioHangChiTiet ghChiTiet = new GioHangChiTiet(giohang,sanpham,soluong);
		listGHCT.add(ghChiTiet);
		gioHangChiTietRepository.saveAll(listGHCT);
		
		//tính tổng tiền
		Double tongtien = (double) 0;
		for(GioHangChiTiet item : listGHCT) {
			tongtien += item.getThanhtien();
		}	
		
		session.removeAttribute("sanpham");
		modelMap.addAttribute("listGHCT", listGHCT);
		modelMap.addAttribute("tongtien", tongtien);
		session.setAttribute("listGHCT", listGHCT);
		return "khachhang/giohang";
	}
	
	@SuppressWarnings("unchecked")
	@GetMapping("/dathang")
	public String dathang(HttpSession session,ModelMap modelMap) {
		GioHang giohang = gioHangRepository.findByKhachhang_id((long)1);
		List<GioHangChiTiet> listGHCT = giohang.getListGHCT();
		KhachHang khachhang = (KhachHang) session.getAttribute("khachhang");
		TrangThai trangThai = new TrangThai((long) 1, "Chờ duyệt đơn");
		//tính tổng tiền
		Double tongtien = (double) 0;
		for(GioHangChiTiet item : listGHCT) {
			tongtien += item.getThanhtien();
		}
		HoaDon hoadon = new HoaDon(tongtien, null, khachhang, null, trangThai);
		hoaDonRepository.save(hoadon);
		
		List<HoaDonChiTiet> listHDCT = new ArrayList<>();
		for(GioHangChiTiet item : listGHCT) {
			HoaDonChiTiet hdct = new HoaDonChiTiet();
			hdct.setSanpham(item.getSanpham());
			hdct.setGiaban(item.getSanpham().getGiaban());
			hdct.setSoluong(item.getSoluong());
			hdct.setHoadon(hoadon);	
			
			listHDCT.add(hdct);
		}
		hoaDonChiTietRepository.saveAll(listHDCT);
		gioHangChiTietRepository.deleteByGiohang_id(giohang.getId());
		hoadon.setListhoadon(listHDCT);
		modelMap.addAttribute("hoadon", hoadon);
		
		session.removeAttribute("listGHCT");
		return "khachhang/donhang";
	}
}
