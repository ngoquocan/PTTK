package com.nhom5.supermarket.service.imp;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nhom5.supermarket.entity.OrderStatusEntity;
import com.nhom5.supermarket.repository.OrderStatusRepository;
import com.nhom5.supermarket.service.OrderStatusService;
@Service
public class OrderStatusServiceImp implements OrderStatusService{

	@Autowired
	private OrderStatusRepository orderStatusRepository;
	@Override
	public String saveOrUpdate(OrderStatusEntity orderStatusEntity) {
		if(orderStatusEntity.getId() == null) {
			orderStatusRepository.save(orderStatusEntity);
			return "Creat Success";
		}
		if(orderStatusRepository.findById(orderStatusEntity.getId()).isEmpty()) {
			throw new NoSuchElementException("Not Found orderStatusId = " + orderStatusEntity.getId());
		}
		else {
			orderStatusRepository.save(orderStatusEntity);
			return "Update Success";
		}
	}

	@Override
	public List<OrderStatusEntity> findAll() {
		return orderStatusRepository.findAll();
	}

	@Override
	public OrderStatusEntity findById(Long id) {
		Optional<OrderStatusEntity> orderStatusEntityOpt = orderStatusRepository.findById(id);
		if(orderStatusEntityOpt.isEmpty()) {
			throw new NoSuchElementException("Not Found orderStatusId = " + id);
		}
		return orderStatusEntityOpt.get();	
	}

	@Override
	public String deleteById(Long id) {
		Optional<OrderStatusEntity> orderStatusEntityOpt = orderStatusRepository.findById(id);
		if(orderStatusEntityOpt.isEmpty()) {
			return "Not Found";
		}
		orderStatusRepository.deleteById(id);
		return "Success";
	}
}
