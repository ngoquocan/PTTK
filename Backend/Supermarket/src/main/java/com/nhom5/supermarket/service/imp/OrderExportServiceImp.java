//package com.nhom5.supermarket.service.imp;
//
//import java.util.List;
//import java.util.NoSuchElementException;
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.nhom5.supermarket.entity.HoaDonNhap;
//import com.nhom5.supermarket.repository.OrderExportRepository;
//import com.nhom5.supermarket.service.OrderExportService;
//@Service
//public class OrderExportServiceImp implements OrderExportService{
//
//	@Autowired
//	private OrderExportRepository orderExportRepository;
//	@Override
//	public String saveOrUpdate(HoaDonNhap orderExportEntity) {
//		orderExportRepository.save(orderExportEntity);
//		return "Success";
//	}
//
//	@Override
//	public List<HoaDonNhap> findAll() {
//		return orderExportRepository.findAll();
//	}
//
//	@Override
//	public HoaDonNhap findById(Long id) {
//		Optional<HoaDonNhap> orderExportEntityOpt = orderExportRepository.findById(id);
//		if(orderExportEntityOpt.isEmpty()) {
//			throw new NoSuchElementException("Not Found orderExportId = " + id);
//		}
//		return orderExportEntityOpt.get();	
//	}
//	@Override
//	public String deleteById(Long id) {
//		Optional<HoaDonNhap> orderExportEntityOpt = orderExportRepository.findById(id);
//		if(orderExportEntityOpt.isEmpty()) {
//			return "Not Found";
//		}
//		orderExportRepository.deleteById(id);
//		return "Success";
//	}
//}
