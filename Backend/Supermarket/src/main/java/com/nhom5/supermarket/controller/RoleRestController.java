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

import com.nhom5.supermarket.entity.RoleEntity;
import com.nhom5.supermarket.service.RoleService;


@RestController
@RequestMapping("/api/roles")
public class RoleRestController {
	@Autowired
	private RoleService roleService;
	
	@PostMapping
	public ResponseEntity<String> add(@RequestBody @Valid RoleEntity roleEntity) {
		String messege = roleService.saveOrUpdate(roleEntity);
		return new ResponseEntity<>(messege, HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<RoleEntity>> getAll(){
		List<RoleEntity> roleEntities = roleService.findAll();
		if(roleEntities.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<RoleEntity>>(roleEntities, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<RoleEntity> getById(@PathVariable(name = "id") Long id){
		RoleEntity roleEntity = roleService.findById(id);
		if(roleEntity == null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<RoleEntity>(roleEntity, HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<String> update(@RequestBody @Valid RoleEntity roleEntity, 
			@PathVariable(name = "id") Long id) {
		roleEntity.setId(id);
		String messege = roleService.saveOrUpdate(roleEntity);
		return new ResponseEntity<>(messege, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteById(@PathVariable(name = "id") Long id){
		String messege = roleService.deleteById(id);
		return new ResponseEntity<String>(messege,HttpStatus.OK);
	}
}
