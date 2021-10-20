package com.nhom5.supermarket.service.imp;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nhom5.supermarket.entity.ImageEntity;
import com.nhom5.supermarket.entity.ProductEntity;
import com.nhom5.supermarket.repository.ProductRepository;
import com.nhom5.supermarket.service.ImageService;
import com.nhom5.supermarket.service.ProductService;
@Service
public class ProductServiceImp implements ProductService{

	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private ImageService imageService;
	@Override
	public String saveOrUpdate(ProductEntity productEntity) {
		if(productEntity.getId() == null) {
			productRepository.save(productEntity);
			List<ImageEntity> listImage = productEntity.getListImage();
			for (ImageEntity imageEntity : listImage) {
				imageEntity.setProduct(productEntity);
				imageService.saveOrUpdate(imageEntity);
			}
			return "Creat Success";
		}
		if(productRepository.findById(productEntity.getId()).isEmpty()) {
			throw new NoSuchElementException("Not Found productId = " + productEntity.getId());
		}
		else {
			productRepository.save(productEntity);
			return "Update Success";
		}
	}

	@Override
	public List<ProductEntity> findAll() {
		List<ProductEntity> listProduct = productRepository.findAll();
		return listProduct;
	}

	@Override
	public ProductEntity findById(Long id) {
		Optional<ProductEntity> productEntityOpt = productRepository.findById(id);
		if(productEntityOpt.isEmpty()) {
			throw new NoSuchElementException("Not Found productId = " + id);
		}		
		return productEntityOpt.get();	
	}

	@Override
	public String deleteById(Long id) {
		Optional<ProductEntity> productEntityOpt = productRepository.findById(id);
		if(productEntityOpt.isEmpty()) {
			return "Not Found";
		}
		productRepository.deleteById(id);
		return "Success";
	}
}
