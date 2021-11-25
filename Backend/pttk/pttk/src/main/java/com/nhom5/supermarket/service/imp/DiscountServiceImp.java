//package com.nhom5.supermarket.service.imp;
//
//import java.util.List;
//import java.util.NoSuchElementException;
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.nhom5.supermarket.entity.GiaGiam;
//import com.nhom5.supermarket.repository.DiscountRepository;
//import com.nhom5.supermarket.service.DiscountService;
//@Service
//public class DiscountServiceImp implements DiscountService{
//
//	@Autowired
//	private DiscountRepository discountRepository;
//	@Override
//	public String saveOrUpdate(GiaGiam discountEntity) {
//		if(discountEntity.getId() == null) {
//			discountRepository.save(discountEntity);
//			return "Creat Success";
//		}
//		if(discountRepository.findById(discountEntity.getId()).isEmpty()) {
//			throw new NoSuchElementException("Not Found discountId = " + discountEntity.getId());
//		}
//		else {
//			discountRepository.save(discountEntity);
//			return "Update Success";
//		}
//	}
//
//	@Override
//	public List<GiaGiam> findAll() {
//		return discountRepository.findAll();
//	}
//
//	@Override
//	public GiaGiam findById(Long id) {
//		Optional<GiaGiam> discountEntityOpt = discountRepository.findById(id);
//		if(discountEntityOpt.isEmpty()) {
//			throw new NoSuchElementException("Not Found discountId = " + id);
//		}
//		return discountEntityOpt.get();	
//	}
//
//	@Override
//	public String deleteById(Long id) {
//		Optional<GiaGiam> discountEntityOpt = discountRepository.findById(id);
//		if(discountEntityOpt.isEmpty()) {
//			return "Not Found";
//		}
//		discountRepository.deleteById(id);
//		return "Success";
//	}
//}
