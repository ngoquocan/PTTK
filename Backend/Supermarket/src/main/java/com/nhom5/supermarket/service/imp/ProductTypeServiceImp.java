package com.nhom5.supermarket.service.imp;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nhom5.supermarket.entity.ProductTypeEntity;
import com.nhom5.supermarket.repository.ProductTypeRepository;
import com.nhom5.supermarket.service.ProductTypeService;
@Service
public class ProductTypeServiceImp implements ProductTypeService{

	@Autowired
	private ProductTypeRepository productTypeRepository;
	@Override
	public String saveOrUpdate(ProductTypeEntity productTypeEntity) {
		if(productTypeEntity.getId() == null) {
			productTypeRepository.save(productTypeEntity);
			return "Creat Success";
		}
		if(productTypeRepository.findById(productTypeEntity.getId()).isEmpty()) {
			throw new NoSuchElementException("Not Found productTypeId = " + productTypeEntity.getId());
		}
		else {
			productTypeRepository.save(productTypeEntity);
			return "Update Success";
		}
	}

	@Override
	public List<ProductTypeEntity> findAll() {
		return productTypeRepository.findAll();
	}

	@Override
	public ProductTypeEntity findById(Long id) {
		Optional<ProductTypeEntity> productTypeEntityOpt = productTypeRepository.findById(id);
		if(productTypeEntityOpt.isEmpty()) {
			throw new NoSuchElementException("Not Found productTypeId = " + id);
		}
		return productTypeEntityOpt.get();	
	}

	@Override
	public String deleteById(Long id) {
		Optional<ProductTypeEntity> productTypeEntityOpt = productTypeRepository.findById(id);
		if(productTypeEntityOpt.isEmpty()) {
			return "Not Found";
		}
		productTypeRepository.deleteById(id);
		return "Success";
	}
}
