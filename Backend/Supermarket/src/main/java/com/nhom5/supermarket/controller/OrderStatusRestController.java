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

import com.nhom5.supermarket.entity.OrderStatusEntity;
import com.nhom5.supermarket.service.OrderStatusService;


@RestController
@RequestMapping("/api/orderStatus")
public class OrderStatusRestController {
	@Autowired
	private OrderStatusService orderStatusService;
	
	@PostMapping
	public ResponseEntity<String> add(@RequestBody @Valid OrderStatusEntity orderStatusEntity) {
		String messege = orderStatusService.saveOrUpdate(orderStatusEntity);
		return new ResponseEntity<>(messege, HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<OrderStatusEntity>> getAll(){
		List<OrderStatusEntity> orderStatusEntities = orderStatusService.findAll();
		if(orderStatusEntities.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<OrderStatusEntity>>(orderStatusEntities, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<OrderStatusEntity> getById(@PathVariable(name = "id") Long id){
		OrderStatusEntity orderStatusEntity = orderStatusService.findById(id);
		if(orderStatusEntity == null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<OrderStatusEntity>(orderStatusEntity, HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<String> update(@RequestBody @Valid OrderStatusEntity orderStatusEntity, 
			@PathVariable(name = "id") Long id) {
		orderStatusEntity.setId(id);
		String messege = orderStatusService.saveOrUpdate(orderStatusEntity);
		return new ResponseEntity<>(messege, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteById(@PathVariable(name = "id") Long id){
		String messege = orderStatusService.deleteById(id);
		return new ResponseEntity<String>(messege,HttpStatus.OK);
	}
}
