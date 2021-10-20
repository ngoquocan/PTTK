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
import com.nhom5.supermarket.entity.CartEntity;
import com.nhom5.supermarket.service.CartDetailService;
import com.nhom5.supermarket.service.CartService;

//OK
@RestController
@RequestMapping("/api/carts")
public class CartRestController {
	@Autowired
	private CartService cartService;
	
	@Autowired
	private CartDetailService cartDetailService;
//	carts request
	@PostMapping
	public ResponseEntity<String> add(@RequestBody @Valid CartEntity cartEntity) {
		String messege = cartService.saveOrUpdate(cartEntity);
		return new ResponseEntity<>(messege, HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<CartEntity>> getAll(){
		List<CartEntity> cartEntities = cartService.findAll();
		if(cartEntities.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<CartEntity>>(cartEntities, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CartEntity> getById(@PathVariable(name = "id") Long id){
		CartEntity cartEntity = cartService.findById(id);
		if(cartEntity == null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<CartEntity>(cartEntity, HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<String> update(@RequestBody @Valid CartEntity cartEntity, 
			@PathVariable(name = "id") Long id) {
		cartEntity.setId(id);
		String messege = cartService.saveOrUpdate(cartEntity);
		return new ResponseEntity<>(messege, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteById(@PathVariable(name = "id") Long id){
		String messege = cartService.deleteById(id);
		return new ResponseEntity<String>(messege,HttpStatus.OK);
	}
	
//	cartdetail request
	//add item to cart
	@PostMapping("/items")
	public ResponseEntity<String> addCartDetail(@RequestBody @Valid CartDetailEntity cartDetailEntity) {
		String messege = cartDetailService.saveOrUpdate(cartDetailEntity);
		return new ResponseEntity<>(messege, HttpStatus.CREATED);
	}
	//get all item in cart
	@GetMapping("/items")
	public ResponseEntity<List<CartDetailEntity>> getByCartId(){
		List<CartDetailEntity> cartDetailEntities = cartDetailService.findAll();
		if(cartDetailEntities.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<CartDetailEntity>>(cartDetailEntities, HttpStatus.OK);
	}
	
	
	@GetMapping("/items/{id}")
	public ResponseEntity<CartDetailEntity> getCartDetailById(@PathVariable(name = "id") Long id){
		CartDetailEntity cartDetailEntity = cartDetailService.findById(id);
		if(cartDetailEntity == null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<CartDetailEntity>(cartDetailEntity, HttpStatus.OK);
	}
	
	@PutMapping("/items/{id}")
	public ResponseEntity<String> updateCartDetail(@RequestBody @Valid CartDetailEntity cartDetailEntity, 
			@PathVariable(name = "id") Long id) {
		cartDetailEntity.setId(id);
		String messege = cartDetailService.saveOrUpdate(cartDetailEntity);
		return new ResponseEntity<>(messege, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/items/{id}")
	public ResponseEntity<String> deleteCartDetailById(@PathVariable(name = "id") Long id){
		String messege = cartDetailService.deleteById(id);
		return new ResponseEntity<String>(messege,HttpStatus.OK);
	}
}
