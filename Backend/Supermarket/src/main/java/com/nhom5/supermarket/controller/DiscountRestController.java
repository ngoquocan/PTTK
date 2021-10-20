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

import com.nhom5.supermarket.entity.DiscountEntity;
import com.nhom5.supermarket.service.DiscountService;


@RestController
@RequestMapping("/api/discounts")
public class DiscountRestController {
	@Autowired
	private DiscountService discountService;
	
	@PostMapping
	public ResponseEntity<String> add(@RequestBody @Valid DiscountEntity discountEntity) {
		String messege = discountService.saveOrUpdate(discountEntity);
		return new ResponseEntity<>(messege, HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<DiscountEntity>> getAll(){
		List<DiscountEntity> discountEntities = discountService.findAll();
		if(discountEntities.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<DiscountEntity>>(discountEntities, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<DiscountEntity> getById(@PathVariable(name = "id") Long id){
		DiscountEntity discountEntity = discountService.findById(id);
		if(discountEntity == null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<DiscountEntity>(discountEntity, HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<String> update(@RequestBody @Valid DiscountEntity discountEntity, 
			@PathVariable(name = "id") Long id) {
		discountEntity.setId(id);
		String messege = discountService.saveOrUpdate(discountEntity);
		return new ResponseEntity<>(messege, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteById(@PathVariable(name = "id") Long id){
		String messege = discountService.deleteById(id);
		return new ResponseEntity<String>(messege,HttpStatus.OK);
	}
}
