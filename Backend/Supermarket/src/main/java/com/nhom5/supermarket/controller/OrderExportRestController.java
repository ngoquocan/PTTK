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

import com.nhom5.supermarket.entity.OrderExportEntity;
import com.nhom5.supermarket.service.OrderExportService;


@RestController
@RequestMapping("/api/orderExports")
public class OrderExportRestController {
	@Autowired
	private OrderExportService orderExportService;
	
	@PostMapping
	public ResponseEntity<String> add(@RequestBody @Valid OrderExportEntity orderExportEntity) {
		String messege = orderExportService.saveOrUpdate(orderExportEntity);
		return new ResponseEntity<>(messege, HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<OrderExportEntity>> getAll(){
		List<OrderExportEntity> orderExportEntities = orderExportService.findAll();
		if(orderExportEntities.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<OrderExportEntity>>(orderExportEntities, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<OrderExportEntity> getById(@PathVariable(name = "id") Long id){
		OrderExportEntity orderExportEntity = orderExportService.findById(id);
		if(orderExportEntity == null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<OrderExportEntity>(orderExportEntity, HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<String> update(@RequestBody @Valid OrderExportEntity orderExportEntity, 
			@PathVariable(name = "id") Long id) {
		orderExportEntity.setId(id);
		String messege = orderExportService.saveOrUpdate(orderExportEntity);
		return new ResponseEntity<>(messege, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteById(@PathVariable(name = "id") Long id){
		String messege = orderExportService.deleteById(id);
		return new ResponseEntity<String>(messege,HttpStatus.OK);
	}
}