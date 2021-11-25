package com.example.demo.controller;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.DiaChi;
import com.example.demo.entity.HoaDon;
import com.example.demo.entity.HoaDonChiTiet;
import com.example.demo.entity.HoaDonNhap;
import com.example.demo.entity.HoaDonNhapChiTiet;
import com.example.demo.entity.LoaiSanPham;
import com.example.demo.entity.NhaCungCap;
import com.example.demo.entity.NhanVien;
import com.example.demo.entity.SanPham;
import com.example.demo.entity.TrangThai;
import com.example.demo.repository.DiaChiRepository;
import com.example.demo.repository.HoaDonNhapChiTietRepository;
import com.example.demo.repository.HoaDonNhapRepository;
import com.example.demo.repository.HoaDonRepository;
import com.example.demo.repository.LoaiSanPhamRepository;
import com.example.demo.repository.NhaCungCapRepository;
import com.example.demo.repository.SanPhamRepository;
import com.example.demo.repository.TrangThaiRepository;

@Controller
@RequestMapping("/nhanvienkho")
@Transactional(rollbackFor = {Exception.class, Throwable.class})
public class NhanVienKhoController {
	
	@Autowired
	private NhaCungCapRepository nhaCungCapRepository;
	@Autowired
	private DiaChiRepository diaChiRepository;
	@Autowired
	private LoaiSanPhamRepository loaiSanPhamRepository;
	@Autowired
	private SanPhamRepository sanPhamRepository;
	@Autowired
	private HoaDonNhapRepository hoaDonNhapRepository;
	@Autowired
	private HoaDonNhapChiTietRepository hdnctRepository;
	@Autowired
	private TrangThaiRepository trangThaiRepository;
	@Autowired
	private HoaDonRepository hoaDonRepository;
	
	@GetMapping("/trangchu")
	private String trangchu(HttpSession session){
		
		return "nhanvienkho/trangchu";
	}
	
	
/*
 * Chức năng thêm nhà cung cấp
 */
	@GetMapping("/themnhacungcap")
	public String themNhaCungCap(ModelMap modelMap) {
		modelMap.addAttribute("nhacungcap", new NhaCungCap());
		return "nhanvienkho/themNhaCungCap";
	}
	
	@PostMapping("/luuNhaCungCap")
	public String luuNhaCungCap(ModelMap modelMap,NhaCungCap nhaCungCap) {
		DiaChi diachi = diaChiRepository.save(nhaCungCap.getDiachi());
		nhaCungCap.setDiachi(diachi);
		nhaCungCapRepository.save(nhaCungCap);
		modelMap.addAttribute("nhacungcap", nhaCungCap);
		return "nhanvienkho/themNhaCungCap";
	}
	
/*
 * Chức năng thêm sản phẩm
 */
	
	@GetMapping("/themsanpham")
	public String themSanPham(ModelMap modelMap,HttpSession session) {
		List<LoaiSanPham> loaiSanPhams = loaiSanPhamRepository.findAll();
		List<NhaCungCap> nhaCungCaps = nhaCungCapRepository.findAll();
		
		modelMap.addAttribute("listLoaiSanPham", loaiSanPhams);
		modelMap.addAttribute("listNhaCungCap", nhaCungCaps);
		
		session.setAttribute("listLoaiSanPham", loaiSanPhams);
		session.setAttribute("listNhaCungCap", nhaCungCaps);
		
		modelMap.addAttribute("sanpham", new SanPham());
		return "nhanvienkho/themSanpham";
	}
	
	@SuppressWarnings("unchecked")
	@PostMapping("/luuSanPham")
	public String luuSanPham(ModelMap modelMap,HttpSession session,SanPham sanPham,
			@RequestParam(name = "loaisanpham") int idLoaiSP,
			@RequestParam(name = "nhacungcap") int idNCC) {
		
		sanPham.setLoai(((List<LoaiSanPham>) session.getAttribute("listLoaiSanPham")).get(idLoaiSP));
		sanPham.setNhacungcap(((List<NhaCungCap>) session.getAttribute("listNhaCungCap")).get(idNCC));
		
		sanPhamRepository.save(sanPham);
		modelMap.addAttribute("sanpham", sanPham);
		
		return "nhanvienkho/themSanPham";
	}

	
/*
 * Chức năng nhập hàng từ nhà cung cấp
 */
	@GetMapping("/chonnhacungcap")
	public String chonNCC(ModelMap modelMap, HttpSession session) {
		List<NhaCungCap> nhaCungCaps = nhaCungCapRepository.findAll();
		modelMap.addAttribute("listNhaCungCap", nhaCungCaps);		
		session.setAttribute("listNhaCungCap", nhaCungCaps);
		return "nhanvienkho/chonnhacungcap";
	}
	
	@SuppressWarnings("unchecked")
	@GetMapping("/chonsanpham")
	public String hienthiDSsanpham(ModelMap modelMap, HttpSession session,
			@RequestParam(name = "nhacungcap",required = false) Integer idNCC) {
		NhaCungCap nhaCungCap = new NhaCungCap();
		if(idNCC != null) {
			nhaCungCap = ((List<NhaCungCap>) session.getAttribute("listNhaCungCap")).get(idNCC);	
			session.setAttribute("nhacungcap", nhaCungCap);
		}
		else {
			nhaCungCap = (NhaCungCap) session.getAttribute("nhacungcap");
		}
		List<SanPham> listSanPham = sanPhamRepository.getListSanPham(nhaCungCap.getId());
		modelMap.addAttribute("listsanpham", listSanPham);
		session.setAttribute("listsanpham", listSanPham);
		return "nhanvienkho/chonsanpham";
	}
	
	@GetMapping("/timkiem")
	public String timsanpham(ModelMap modelMap,HttpSession session, @RequestParam(name = "data") String data) {
		NhaCungCap nhaCungCap = (NhaCungCap) session.getAttribute("nhacungcap");
		List<SanPham> listSanPham = sanPhamRepository.findByNhacungcap_idAndTenContaining(nhaCungCap.getId(), data);
		modelMap.addAttribute("listsanpham", listSanPham);
		session.setAttribute("listsanpham", listSanPham);
		return "nhanvienkho/chonsanpham";
	}
	@SuppressWarnings("unchecked")
	@GetMapping("/chitietsanpham")
	public String chitietsanpham(ModelMap modelMap,HttpSession session, @RequestParam(name = "index") int index) {
		//tạo chi tiết hóa đơn nhập nháp
		
		SanPham sanpham = ((List<SanPham>)session.getAttribute("listsanpham")).get(index);
		HoaDonNhapChiTiet hdnct = new HoaDonNhapChiTiet(sanpham);
		modelMap.addAttribute("hdnct", hdnct);
		session.setAttribute("hdnct", hdnct);
		return "nhanvienkho/chitietsanpham";
	}
	
	@SuppressWarnings("unchecked")
	@GetMapping("/nhaphang")
	public String nhaphang(ModelMap modelMap,HttpSession session,
			@RequestParam(name = "soluong") int soluong) {
		
		//thêm sản phẩm vè hdct vừa chọn
		HoaDonNhapChiTiet hdnct = (HoaDonNhapChiTiet) session.getAttribute("hdnct");
		hdnct.setSoluong(soluong);
		
		//cập nhật sản phẩm vào list hóa đơn nhập chi tiết
		List<HoaDonNhapChiTiet> listHDNCT = new ArrayList<>();
		if(session.getAttribute("listHDNCT") != null) {
			listHDNCT = (List<HoaDonNhapChiTiet>) session.getAttribute("listHDNCT");
		}
		listHDNCT.add(hdnct);
		
		//tính tổng tiền
		Double tongtien = (double) 0;
		for(HoaDonNhapChiTiet item : listHDNCT) {
			tongtien += item.getThanhtien();
		}
		
		session.removeAttribute("hdnct");
		modelMap.addAttribute("listHDNCT", listHDNCT);
		session.setAttribute("listHDNCT", listHDNCT);		
		modelMap.addAttribute("tongtien", tongtien);
		return "nhanvienkho/nhaphang";
	}
	
	@SuppressWarnings("unchecked")
	@GetMapping("/luuhoadonnhap")
	public String luuhoadonnhap(HttpSession session,ModelMap modelMap) {
		List<HoaDonNhapChiTiet> list = (List<HoaDonNhapChiTiet>) session.getAttribute("listHDNCT");
		NhanVien nhanvien = (NhanVien) session.getAttribute("nhanvienkho");
		NhaCungCap ncc = (NhaCungCap) session.getAttribute("nhacungcap");
		Double tongtien = (double) 0;
		for(HoaDonNhapChiTiet item : list) {
			tongtien += item.getThanhtien();
		}
		// lấy thời gian
		long millis = System.currentTimeMillis();
		Timestamp time = new Timestamp(millis);

		//luu hoa don
		HoaDonNhap hoaDonNhap = new HoaDonNhap(tongtien, time, nhanvien, ncc);
		hoaDonNhap = hoaDonNhapRepository.save(hoaDonNhap);
		for(HoaDonNhapChiTiet item : list) {
			item.setHoadonnhap(hoaDonNhap);
		}
		hdnctRepository.saveAll(list);
		
		//capnhatsanpham
		List<SanPham> listSanPham = new ArrayList<>();
		for(HoaDonNhapChiTiet item : list) {
			SanPham sp = item.getSanpham();
			sp.setSoluong(sp.getSoluong() + item.getSoluong());
			listSanPham.add(sp);
		}
		sanPhamRepository.saveAll(listSanPham);
		
		modelMap.addAttribute("listHDNCT", list);
		modelMap.addAttribute("tongtien", tongtien);
		
		session.removeAttribute("listHDNCT");
		session.removeAttribute("nhacungcap");
		return "nhanvienkho/thongtinhoadon";
	}
	
/*
 * Chức năng duyệt đơn + xuất kho
 */
	@GetMapping("/quanlydonhang")
	public String showGDQuanLyDonHang(ModelMap modelMap, HttpSession session,@RequestParam(name = "trangthai", required = false) Long idTrangThai) {
		
		List<TrangThai> listTrangThai =  trangThaiRepository.findAll();
		List<HoaDon> listHoaDon = new ArrayList<>();
		if(idTrangThai == null) {
			listHoaDon = hoaDonRepository.findAll();
		}
		else {
			listHoaDon = hoaDonRepository.findByTrangthai_id(idTrangThai);
		}
		modelMap.addAttribute("listhoadon",listHoaDon);
		modelMap.addAttribute("listtrangthai", listTrangThai);
		session.setAttribute("listhoadon", listHoaDon);
		return "nhanvienkho/gdQuanLyDonHang";
	}
	
	@SuppressWarnings("unchecked")
	@GetMapping("/chitiethoadon")
	public String showGDduyetdon(ModelMap modelMap, HttpSession session,@RequestParam(name = "index") int index) {
		
		HoaDon hoadon = ((List<HoaDon>) session.getAttribute("listhoadon")).get(index);
		System.out.println(hoadon.getListhoadon());
		modelMap.addAttribute("hoadon", hoadon);
		session.setAttribute("hoadon", hoadon);
		if(hoadon.getTrangthai().getTen().equals("Chờ duyệt đơn")) {
			return "nhanvienkho/gdDuyetDon";
		}
		else {
			return "nhanvienkho/gdXuatKho";
		}
	}
	
	@GetMapping("/duyetdon")
	public String duyetdon(ModelMap modelMap, HttpSession session) {
		NhanVien nhanvien = (NhanVien) session.getAttribute("nhanvienkho");
		HoaDon hoadon = (HoaDon) session.getAttribute("hoadon");
		hoadon.setTrangthai(new TrangThai((long)2,"Chờ xuất kho"));
		hoadon.setNhanvien(nhanvien);
		hoaDonRepository.save(hoadon);
		
		List<TrangThai> listTrangThai =  trangThaiRepository.findAll();
		List<HoaDon> listHoaDon = hoaDonRepository.findAll();
		modelMap.addAttribute("listhoadon",listHoaDon);
		modelMap.addAttribute("listtrangthai", listTrangThai);
		session.setAttribute("listhoadon", listHoaDon);
		return "nhanvienkho/gdQuanLyDonHang";
	}
	
	@GetMapping("/xuatkho")
	public String xuatkho(ModelMap modelMap, HttpSession session) {
		NhanVien nhanvien = (NhanVien) session.getAttribute("nhanvienkho");
		HoaDon hoadon = (HoaDon) session.getAttribute("hoadon");
		hoadon.setTrangthai(new TrangThai((long)3,"Đang giao hàng"));
		hoadon.setNhanvien(nhanvien);
		// lấy thời gian
		long millis = System.currentTimeMillis();
		Timestamp time = new Timestamp(millis);
		hoadon.setNgayxuat(time);
		
		// capnhatsanpham
		List<SanPham> listSanPham = new ArrayList<>();
		for (HoaDonChiTiet item : hoadon.getListhoadon()) {
			SanPham sp = item.getSanpham();
			sp.setSoluong(sp.getSoluong() - item.getSoluong());
			listSanPham.add(sp);
		}
		sanPhamRepository.saveAll(listSanPham);
		hoaDonRepository.save(hoadon);

		List<TrangThai> listTrangThai =  trangThaiRepository.findAll();
		List<HoaDon> listHoaDon = hoaDonRepository.findAll();
		modelMap.addAttribute("listhoadon",listHoaDon);
		modelMap.addAttribute("listtrangthai", listTrangThai);
		session.setAttribute("listhoadon", listHoaDon);
		return "nhanvienkho/gdQuanLyDonHang";
	}
	
}
