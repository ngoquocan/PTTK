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

import com.nhom5.supermarket.entity.OrderEntity;
import com.nhom5.supermarket.service.OrderService;


@RestController
@RequestMapping("/api/orders")
public class OrderRestController {
	@Autowired
	private OrderService orderService;
	
	@PostMapping
	public ResponseEntity<String> add(@RequestBody @Valid OrderEntity orderEntity) {
		String messege = orderService.saveOrUpdate(orderEntity);
		return new ResponseEntity<>(messege, HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<OrderEntity>> getAll(){
		List<OrderEntity> orderEntities = orderService.findAll();
		if(orderEntities.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<OrderEntity>>(orderEntities, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<OrderEntity> getById(@PathVariable(name = "id") Long id){
		OrderEntity orderEntity = orderService.findById(id);
		if(orderEntity == null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<OrderEntity>(orderEntity, HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<String> update(@RequestBody @Valid OrderEntity orderEntity, 
			@PathVariable(name = "id") Long id) {
		orderEntity.setId(id);
		String messege = orderService.saveOrUpdate(orderEntity);
		return new ResponseEntity<>(messege, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteById(@PathVariable(name = "id") Long id){
		String messege = orderService.deleteById(id);
		return new ResponseEntity<String>(messege,HttpStatus.OK);
	}
}
