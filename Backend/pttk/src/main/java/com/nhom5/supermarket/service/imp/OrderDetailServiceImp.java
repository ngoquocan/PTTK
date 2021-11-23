//package com.nhom5.supermarket.service.imp;
//
//import java.util.List;
//import java.util.NoSuchElementException;
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.nhom5.supermarket.entity.HoaDonChiTiet;
//import com.nhom5.supermarket.repository.OrderDetailRepository;
//import com.nhom5.supermarket.service.OrderDetailService;
//
//@Service
//public class OrderDetailServiceImp implements OrderDetailService{
//	@Autowired
//	private OrderDetailRepository orderDetailRepository;
//	@Override
//	public String saveOrUpdate(HoaDonChiTiet orderDetailEntity) {
//		orderDetailRepository.save(orderDetailEntity);
//		return "Success";
//	}
//
//	@Override
//	public List<HoaDonChiTiet> findAll() {
//		return orderDetailRepository.findAll();
//	}
//
//	@Override
//	public HoaDonChiTiet findById(Long id) {
//		Optional<HoaDonChiTiet> orderDetailEntityOpt = orderDetailRepository.findById(id);
//		if(orderDetailEntityOpt.isEmpty()) {
//			throw new NoSuchElementException("Not Found orderDetailId = " + id);
//		}
//		return orderDetailEntityOpt.get();	
//	}
//
//	@Override
//	public String deleteById(Long id) {
//		Optional<HoaDonChiTiet> orderDetailEntityOpt = orderDetailRepository.findById(id);
//		if(orderDetailEntityOpt.isEmpty()) {
//			return "Not Found";
//		}
//		orderDetailRepository.deleteById(id);
//		return "Success";
//	}
//
//	@Override
//	public List<HoaDonChiTiet> findByOrderId(Long id) {
//		return orderDetailRepository.findByOrderId(id);
//	}
//}
