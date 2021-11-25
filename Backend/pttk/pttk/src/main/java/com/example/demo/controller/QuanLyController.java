package com.example.demo.controller;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.HoaDon;
import com.example.demo.entity.HoaDonNhap;
import com.example.demo.entity.SanPham;
import com.example.demo.entity.ThongKeNhaCungCap;
import com.example.demo.entity.ThongKeSanPham;
import com.example.demo.repository.HoaDonChiTietRepository;
import com.example.demo.repository.HoaDonNhapRepository;
import com.example.demo.repository.NhaCungCapRepository;
import com.example.demo.repository.SanPhamRepository;

@Controller
@RequestMapping("/quanly")
@Transactional(rollbackFor = {Exception.class, Throwable.class})
public class QuanLyController {
	
	@Autowired
	private NhaCungCapRepository nhaCungCapRepository;
	@Autowired
	private HoaDonNhapRepository hoaDonNhapRepository;
	@Autowired
	private HoaDonChiTietRepository hoaDonChiTietRepository;
	@Autowired
	private SanPhamRepository sanPhamRepository;
	
	
/*
 * Thống kê nhà cung cấp
 */
	@GetMapping("/thongkenhacungcap")
	public String thongkeNCC(ModelMap modelMap,HttpSession session) throws ParseException {
		String s1 = "2021-11-01",s2 = "2021-11-31";
		Date start = new SimpleDateFormat("yyyy-MM-dd").parse(s1);
		Date end = new SimpleDateFormat("yyyy-MM-dd").parse(s2);
		
				
		List<Object[]> list =  nhaCungCapRepository.getTop10NCC(start,end);
		List<ThongKeNhaCungCap> listTKNCC = new ArrayList<>();
		for(Object[] o : list) {
			ThongKeNhaCungCap tkncc = new ThongKeNhaCungCap();
			tkncc.setId(Long.parseLong(o[0].toString()));
			tkncc.setTen((String) o[1]);
			tkncc.setTongtien((double) o[2]);
			listTKNCC.add(tkncc);
		}
		session.setAttribute("start", start);
		session.setAttribute("end", end);
		System.out.println(listTKNCC);
		modelMap.addAttribute("listTKNCC", listTKNCC);
		return "quanly/thongkenhacungcap";
	}
	
	@SuppressWarnings("unused")
	@GetMapping("/thongkehoadonnhap/{id}")
	public String danhsachhoadon(ModelMap modelMap,HttpSession session,
			@PathVariable(value = "id") Long id) {
		Date start = (Date) session.getAttribute("start");
		Date end = (Date) session.getAttribute("end");
		
		List<HoaDonNhap> listHoaDonNhap = hoaDonNhapRepository.findByNhacungcap(id, start, end);
		System.out.println(listHoaDonNhap);
		modelMap.addAttribute("listhoadonnhap", listHoaDonNhap);
		session.setAttribute("listhoadonnhap", listHoaDonNhap);
		return "quanly/thongkehoadonnhap";
	}
	
	@SuppressWarnings("unchecked")
	@GetMapping("/chitiethoadonnhap")
	public String chitiethoadon(ModelMap modelMap,HttpSession session,@RequestParam(name = "index") int index) {		
		HoaDonNhap hoadonnhap = ((List<HoaDonNhap>) session.getAttribute("listhoadonnhap")).get(index);
		modelMap.addAttribute("hoadonnhap", hoadonnhap);
		
		return "quanly/chitiethoadonnhap";
	}
	
/*
 * Thống kê sản phẩm theo doanh thu
 */
	@GetMapping("/thongkesanpham")
	public String thongkeSanPham(ModelMap modelMap,HttpSession session) throws ParseException {
		String s1 = "2021-11-01",s2 = "2021-11-31";
		Date start = new SimpleDateFormat("yyyy-MM-dd").parse(s1);
		Date end = new SimpleDateFormat("yyyy-MM-dd").parse(s2);
		
				
		List<Object[]> list =  hoaDonChiTietRepository.thongKeSanPhamTheoDoanhThu(start,end);
		List<ThongKeSanPham> listTKSP = new ArrayList<>();
		Double tongtien = (double) 0;
		for(Object[] o : list) {
			ThongKeSanPham tksp = new ThongKeSanPham();
			tksp.setId(Long.parseLong(o[0].toString()));
			tksp.setTensanpham((String) o[1]);
			tksp.setTennhacungcap((String) o[2]);
			tksp.setSoluong(Integer.parseInt(o[3].toString()));
			tksp.setTongtien((double) o[4]);
			
			listTKSP.add(tksp);
			tongtien += tksp.getTongtien();
		}
		modelMap.addAttribute("listTKSP", listTKSP);
		modelMap.addAttribute("tongtien", tongtien);
		session.setAttribute("listTKSP", listTKSP);
		return "quanly/thongkesanpham";
	}
	@GetMapping("/chitietsanpham/{id}")
	public String chitietsanpham(ModelMap modelMap, @PathVariable(value = "id") Long id) {
		SanPham sanpham = sanPhamRepository.findById(id).get();
		modelMap.addAttribute("sanpham", sanpham);
		return "quanly/chitietsanpham";
	}
}
