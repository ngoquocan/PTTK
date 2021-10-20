package com.nhom5.supermarket.service.imp;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nhom5.supermarket.entity.CartDetailEntity;
import com.nhom5.supermarket.repository.CartDetailRepository;
import com.nhom5.supermarket.service.CartDetailService;
@Service
public class CartDetailServiceImp implements CartDetailService{
	@Autowired
	private CartDetailRepository cartDetailRepository;
	@Override
	public String saveOrUpdate(CartDetailEntity cartDetailEntity) {
		cartDetailRepository.save(cartDetailEntity);
		return "Success";
	}

	@Override
	public List<CartDetailEntity> findAll() {
		return cartDetailRepository.findAll();
	}

	@Override
	public CartDetailEntity findById(Long id) {
		Optional<CartDetailEntity> cartDetailEntityOpt = cartDetailRepository.findById(id);
		if(cartDetailEntityOpt.isEmpty()) {
			throw new NoSuchElementException("Not Found cartDetailId = " + id);
		}
		return cartDetailEntityOpt.get();	
	}

	@Override
	public String deleteById(Long id) {
		Optional<CartDetailEntity> cartDetailEntityOpt = cartDetailRepository.findById(id);
		if(cartDetailEntityOpt.isEmpty()) {
			return "Not Found";
		}
		cartDetailRepository.deleteById(id);
		return "Success";
	}

	@Override
	public List<CartDetailEntity> findByCartId(Long id) {
		return cartDetailRepository.findByCartId(id);
	}
}
