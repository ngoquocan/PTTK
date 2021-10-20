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

import com.nhom5.supermarket.entity.ProductEntity;
import com.nhom5.supermarket.service.ProductService;


@RestController
@RequestMapping("/api/products")
public class ProductRestController {
	@Autowired
	private ProductService productService;
	
	@PostMapping
	public ResponseEntity<String> add(@RequestBody @Valid ProductEntity productEntity) {
		String messege = productService.saveOrUpdate(productEntity);
		return new ResponseEntity<>(messege, HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<ProductEntity>> getAll(){
		List<ProductEntity> productEntities = productService.findAll();
		if(productEntities.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<ProductEntity>>(productEntities, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ProductEntity> getById(@PathVariable(name = "id") Long id){
		ProductEntity productEntity = productService.findById(id);
		if(productEntity == null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<ProductEntity>(productEntity, HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<String> update(@RequestBody @Valid ProductEntity productEntity, 
			@PathVariable(name = "id") Long id) {
		productEntity.setId(id);
		String messege = productService.saveOrUpdate(productEntity);
		return new ResponseEntity<>(messege, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteById(@PathVariable(name = "id") Long id){
		String messege = productService.deleteById(id);
		return new ResponseEntity<String>(messege,HttpStatus.OK);
	}
}
