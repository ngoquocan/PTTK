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

import com.nhom5.supermarket.entity.EmployeeEntity;
import com.nhom5.supermarket.service.EmployeeService;


@RestController
@RequestMapping("/api/employees")
public class EmployeeRestController {
	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping
	public ResponseEntity<String> add(@RequestBody @Valid EmployeeEntity employeeEntity) {
		String messege = employeeService.saveOrUpdate(employeeEntity);
		return new ResponseEntity<>(messege, HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<EmployeeEntity>> getAll(){
		List<EmployeeEntity> employeeEntities = employeeService.findAll();
		if(employeeEntities.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<EmployeeEntity>>(employeeEntities, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<EmployeeEntity> getById(@PathVariable(name = "id") Long id){
		EmployeeEntity employeeEntity = employeeService.findById(id);
		if(employeeEntity == null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<EmployeeEntity>(employeeEntity, HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<String> update(@RequestBody @Valid EmployeeEntity employeeEntity, 
			@PathVariable(name = "id") Long id) {
		employeeEntity.setId(id);
		String messege = employeeService.saveOrUpdate(employeeEntity);
		return new ResponseEntity<>(messege, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteById(@PathVariable(name = "id") Long id){
		String messege = employeeService.deleteById(id);
		return new ResponseEntity<String>(messege,HttpStatus.OK);
	}
}
