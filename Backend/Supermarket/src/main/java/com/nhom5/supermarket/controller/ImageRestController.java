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

import com.nhom5.supermarket.entity.ImageEntity;
import com.nhom5.supermarket.service.ImageService;


@RestController
@RequestMapping("/api/images")
public class ImageRestController {
	@Autowired
	private ImageService imageService;
	
	@PostMapping
	public ResponseEntity<String> add(@RequestBody @Valid ImageEntity imageEntity) {
		String messege = imageService.saveOrUpdate(imageEntity);
		return new ResponseEntity<>(messege, HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<ImageEntity>> getAll(){
		List<ImageEntity> imageEntities = imageService.findAll();
		if(imageEntities.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<ImageEntity>>(imageEntities, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ImageEntity> getById(@PathVariable(name = "id") Long id){
		ImageEntity imageEntity = imageService.findById(id);
		if(imageEntity == null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<ImageEntity>(imageEntity, HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<String> update(@RequestBody @Valid ImageEntity imageEntity, 
			@PathVariable(name = "id") Long id) {
		imageEntity.setId(id);
		String messege = imageService.saveOrUpdate(imageEntity);
		return new ResponseEntity<>(messege, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteById(@PathVariable(name = "id") Long id){
		String messege = imageService.deleteById(id);
		return new ResponseEntity<String>(messege,HttpStatus.OK);
	}
}
