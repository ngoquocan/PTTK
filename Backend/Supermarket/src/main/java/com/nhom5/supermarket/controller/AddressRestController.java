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

import com.nhom5.supermarket.entity.AddressEntity;
import com.nhom5.supermarket.service.AddressService;


@RestController
@RequestMapping("/api/address")
public class AddressRestController {
	@Autowired
	private AddressService addressService;
	
	@PostMapping
	public ResponseEntity<String> add(@RequestBody @Valid AddressEntity addressEntity) {
		String messege = addressService.saveOrUpdate(addressEntity);
		return new ResponseEntity<>(messege, HttpStatus.CREATED);
	}
	
	@GetMapping	
	public ResponseEntity<List<AddressEntity>> getAll(){
		List<AddressEntity> addressEntities = addressService.findAll();
		if(addressEntities.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<AddressEntity>>(addressEntities, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<AddressEntity> getById(@PathVariable(name = "id") Long id){
		AddressEntity addressEntity = addressService.findById(id);
		if(addressEntity == null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<AddressEntity>(addressEntity, HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<String> update(@RequestBody @Valid AddressEntity addressEntity, 
			@PathVariable(name = "id") Long id) {
		addressEntity.setId(id);
		String messege = addressService.saveOrUpdate(addressEntity);
		return new ResponseEntity<>(messege, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteById(@PathVariable(name = "id") Long id){
		String messege = addressService.deleteById(id);
		return new ResponseEntity<String>(messege,HttpStatus.OK);
	}
}
