//package com.nhom5.supermarket.service.imp;
//
//import java.util.List;
//import java.util.NoSuchElementException;
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.nhom5.supermarket.entity.GioHang;
//import com.nhom5.supermarket.repository.CartRepository;
//import com.nhom5.supermarket.service.CartService;
//@Service
//public class CartServiceImp implements CartService{
//	@Autowired
//	private CartRepository cartRepository;
//	@Override
//	public String saveOrUpdate(GioHang cartEntity) {
//		cartRepository.save(cartEntity);
//		return "Success";
//	}
//
//	@Override
//	public List<GioHang> findAll() {
//		return cartRepository.findAll();
//	}
//
//	@Override
//	public GioHang findById(Long id) {
//		Optional<GioHang> cartEntityOpt = cartRepository.findById(id);
//		if(cartEntityOpt.isEmpty()) {
//			throw new NoSuchElementException("Not Found cartId = " + id);
//		}
//		return cartEntityOpt.get();	
//	}
//
//	@Override
//	public String deleteById(Long id) {
//		Optional<GioHang> cartEntityOpt = cartRepository.findById(id);
//		if(cartEntityOpt.isEmpty()) {
//			return "Not Found";
//		}
//		cartRepository.deleteById(id);
//		return "Success";
//	}
//
//	@Override
//	public GioHang findByCustomerId(Long id) {
//		GioHang cartEntity = cartRepository.findByCustomerId(id);
//		if(cartEntity == null) {
//			throw new NoSuchElementException("Not Found userId = " + id);
//		}
//		return cartEntity;
//	}
//}
