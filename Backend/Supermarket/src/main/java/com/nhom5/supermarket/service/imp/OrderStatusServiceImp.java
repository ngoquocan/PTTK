//package com.nhom5.supermarket.service.imp;
//
//import java.util.List;
//import java.util.NoSuchElementException;
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.nhom5.supermarket.entity.TrangThai;
//import com.nhom5.supermarket.repository.OrderStatusRepository;
//import com.nhom5.supermarket.service.OrderStatusService;
//@Service
//public class OrderStatusServiceImp implements OrderStatusService{
//
//	@Autowired
//	private OrderStatusRepository orderStatusRepository;
//	@Override
//	public String saveOrUpdate(TrangThai orderStatusEntity) {
//		if(orderStatusEntity.getId() == null) {
//			orderStatusRepository.save(orderStatusEntity);
//			return "Creat Success";
//		}
//		if(orderStatusRepository.findById(orderStatusEntity.getId()).isEmpty()) {
//			throw new NoSuchElementException("Not Found orderStatusId = " + orderStatusEntity.getId());
//		}
//		else {
//			orderStatusRepository.save(orderStatusEntity);
//			return "Update Success";
//		}
//	}
//
//	@Override
//	public List<TrangThai> findAll() {
//		return orderStatusRepository.findAll();
//	}
//
//	@Override
//	public TrangThai findById(Long id) {
//		Optional<TrangThai> orderStatusEntityOpt = orderStatusRepository.findById(id);
//		if(orderStatusEntityOpt.isEmpty()) {
//			throw new NoSuchElementException("Not Found orderStatusId = " + id);
//		}
//		return orderStatusEntityOpt.get();	
//	}
//
//	@Override
//	public String deleteById(Long id) {
//		Optional<TrangThai> orderStatusEntityOpt = orderStatusRepository.findById(id);
//		if(orderStatusEntityOpt.isEmpty()) {
//			return "Not Found";
//		}
//		orderStatusRepository.deleteById(id);
//		return "Success";
//	}
//}
