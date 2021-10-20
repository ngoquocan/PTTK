package com.nhom5.supermarket.service.imp;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nhom5.supermarket.entity.OrderDetailEntity;
import com.nhom5.supermarket.entity.OrderEntity;
import com.nhom5.supermarket.repository.OrderDetailRepository;
import com.nhom5.supermarket.repository.OrderRepository;
import com.nhom5.supermarket.service.OrderService;
@Service
public class OrderServiceImp implements OrderService{

	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private OrderDetailRepository orderDetailRepository;
	@Override
	public String saveOrUpdate(OrderEntity orderEntity) {
		orderRepository.save(orderEntity);
		orderEntity = orderRepository.findFirstByOrderByIdDesc();
		for (OrderDetailEntity orderDetail : orderEntity.getListOrderDetail()) {
			orderDetail.setOrder(orderEntity);
			orderDetailRepository.save(orderDetail);
		}
		return "Success";
	}

	@Override
	public List<OrderEntity> findAll() {
		return orderRepository.findAll();
	}

	@Override
	public OrderEntity findById(Long id) {
		Optional<OrderEntity> orderEntityOpt = orderRepository.findById(id);
		if(orderEntityOpt.isEmpty()) {
			throw new NoSuchElementException("Not Found orderId = " + id);
		}
		return orderEntityOpt.get();	
	}

	@Override
	public String deleteById(Long id) {
		Optional<OrderEntity> orderEntityOpt = orderRepository.findById(id);
		if(orderEntityOpt.isEmpty()) {
			return "Not Found";
		}
		orderRepository.deleteById(id);
		return "Success";
	}

	@Override
	public List<OrderEntity> findByCustomerId(Long id) {
		return orderRepository.findByCustomerId(id);
	}
}
