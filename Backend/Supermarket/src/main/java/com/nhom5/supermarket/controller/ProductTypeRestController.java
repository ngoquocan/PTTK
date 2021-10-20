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

import com.nhom5.supermarket.entity.ProductTypeEntity;
import com.nhom5.supermarket.service.ProductTypeService;


@RestController
@RequestMapping("/api/productTypes")
public class ProductTypeRestController {
	@Autowired
	private ProductTypeService productTypeService;
	
	@PostMapping
	public ResponseEntity<String> add(@RequestBody @Valid ProductTypeEntity productTypeEntity) {
		String messege = productTypeService.saveOrUpdate(productTypeEntity);
		return new ResponseEntity<>(messege, HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<ProductTypeEntity>> getAll(){
		List<ProductTypeEntity> productTypeEntities = productTypeService.findAll();
		if(productTypeEntities.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<ProductTypeEntity>>(productTypeEntities, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ProductTypeEntity> getById(@PathVariable(name = "id") Long id){
		ProductTypeEntity productTypeEntity = productTypeService.findById(id);
		if(productTypeEntity == null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<ProductTypeEntity>(productTypeEntity, HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<String> update(@RequestBody @Valid ProductTypeEntity productTypeEntity, 
			@PathVariable(name = "id") Long id) {
		productTypeEntity.setId(id);
		String messege = productTypeService.saveOrUpdate(productTypeEntity);
		return new ResponseEntity<>(messege, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteById(@PathVariable(name = "id") Long id){
		String messege = productTypeService.deleteById(id);
		return new ResponseEntity<String>(messege,HttpStatus.OK);
	}
}
