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

import com.nhom5.supermarket.entity.SupplierEntity;
import com.nhom5.supermarket.service.SupplierService;


@RestController
@RequestMapping("/api/suppliers")
public class SupplierRestController {
	@Autowired
	private SupplierService supplierService;
	
	@PostMapping
	public ResponseEntity<String> add(@RequestBody @Valid SupplierEntity supplierEntity) {
		String messege = supplierService.saveOrUpdate(supplierEntity);
		return new ResponseEntity<>(messege, HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<SupplierEntity>> getAll(){
		List<SupplierEntity> supplierEntities = supplierService.findAll();
		if(supplierEntities.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<SupplierEntity>>(supplierEntities, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<SupplierEntity> getById(@PathVariable(name = "id") Long id){
		SupplierEntity supplierEntity = supplierService.findById(id);
		if(supplierEntity == null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<SupplierEntity>(supplierEntity, HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<String> update(@RequestBody @Valid SupplierEntity supplierEntity, 
			@PathVariable(name = "id") Long id) {
		supplierEntity.setId(id);
		String messege = supplierService.saveOrUpdate(supplierEntity);
		return new ResponseEntity<>(messege, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteById(@PathVariable(name = "id") Long id){
		String messege = supplierService.deleteById(id);
		return new ResponseEntity<String>(messege,HttpStatus.OK);
	}
}
