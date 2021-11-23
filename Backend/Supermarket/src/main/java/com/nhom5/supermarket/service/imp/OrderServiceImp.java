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
//import com.nhom5.supermarket.entity.HoaDon;
//import com.nhom5.supermarket.repository.OrderDetailRepository;
//import com.nhom5.supermarket.repository.OrderRepository;
//import com.nhom5.supermarket.service.OrderService;
//@Service
//public class OrderServiceImp implements OrderService{
//
//	@Autowired
//	private OrderRepository orderRepository;
//	
//	@Autowired
//	private OrderDetailRepository orderDetailRepository;
//	@Override
//	public String saveOrUpdate(HoaDon orderEntity) {
//		orderRepository.save(orderEntity);
//		orderEntity = orderRepository.findFirstByOrderByIdDesc();
//		for (HoaDonChiTiet orderDetail : orderEntity.getListOrderDetail()) {
//			orderDetail.setOrder(orderEntity);
//			orderDetailRepository.save(orderDetail);
//		}
//		return "Success";
//	}
//
//	@Override
//	public List<HoaDon> findAll() {
//		return orderRepository.findAll();
//	}
//
//	@Override
//	public HoaDon findById(Long id) {
//		Optional<HoaDon> orderEntityOpt = orderRepository.findById(id);
//		if(orderEntityOpt.isEmpty()) {
//			throw new NoSuchElementException("Not Found orderId = " + id);
//		}
//		return orderEntityOpt.get();	
//	}
//
//	@Override
//	public String deleteById(Long id) {
//		Optional<HoaDon> orderEntityOpt = orderRepository.findById(id);
//		if(orderEntityOpt.isEmpty()) {
//			return "Not Found";
//		}
//		orderRepository.deleteById(id);
//		return "Success";
//	}
//
//	@Override
//	public List<HoaDon> findByCustomerId(Long id) {
//		return orderRepository.findByCustomerId(id);
//	}
//}
