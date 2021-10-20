package com.nhom5.supermarket.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nhom5.supermarket.entity.CartDetailEntity;
import com.nhom5.supermarket.entity.CustomerEntity;
import com.nhom5.supermarket.entity.OrderEntity;
import com.nhom5.supermarket.service.CartDetailService;
import com.nhom5.supermarket.service.CartService;
import com.nhom5.supermarket.service.CustomerService;
import com.nhom5.supermarket.service.OrderService;


@RestController
@RequestMapping("/api/customers")
public class CustomerRestController {
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private CartDetailService cartDetailService;
	
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private CartService cartService;
	
	@PostMapping
	public ResponseEntity<String> add(@RequestBody @Valid CustomerEntity customerEntity) {
		String messege = customerService.saveOrUpdate(customerEntity);
		return new ResponseEntity<>(messege, HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<CustomerEntity>> getAll(){
		List<CustomerEntity> customerEntities = customerService.findAll();
		if(customerEntities.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<CustomerEntity>>(customerEntities, HttpStatus.OK);
	}
	
	@GetMapping("/carts/{id}")
	public ResponseEntity<List<CartDetailEntity>> getAllItemInCart(@PathVariable(name = "id") Long customerId){
		//tìm id cart theo user id
		Long cartId = cartService.findByCustomerId(customerId).getId();
		List<CartDetailEntity> listItem = cartDetailService.findByCartId(cartId);
		if(listItem.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<CartDetailEntity>>(listItem, HttpStatus.OK);
	}
	
	@GetMapping("/orders/{id}")
	public ResponseEntity<List<OrderEntity>> getAllOrder(@PathVariable(name = "id") Long customerId){
		List<OrderEntity> listOrder = orderService.findByCustomerId(customerId);
		if(listOrder.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<OrderEntity>>(listOrder, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CustomerEntity> getById(@PathVariable(name = "id") Long id){
		CustomerEntity customerEntity = customerService.findById(id);
		if(customerEntity == null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<CustomerEntity>(customerEntity, HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<String> update(@RequestBody @Valid CustomerEntity customerEntity, 
			@PathVariable(name = "id") Long id) {
		customerEntity.setId(id);
		String messege = customerService.saveOrUpdate(customerEntity);
		return new ResponseEntity<>(messege, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteById(@PathVariable(name = "id") Long id){
		String messege = customerService.deleteById(id);
		return new ResponseEntity<String>(messege,HttpStatus.OK);
	}
}
