//package com.nhom5.supermarket.service.imp;
//
//import java.util.List;
//import java.util.NoSuchElementException;
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.nhom5.supermarket.entity.Anh;
//import com.nhom5.supermarket.entity.SanPham;
//import com.nhom5.supermarket.repository.ProductRepository;
//import com.nhom5.supermarket.service.ImageService;
//import com.nhom5.supermarket.service.ProductService;
//@Service
//public class ProductServiceImp implements ProductService{
//
//	@Autowired
//	private ProductRepository productRepository;
//	
//	@Autowired
//	private ImageService imageService;
//	@Override
//	public String saveOrUpdate(SanPham productEntity) {
//		if(productEntity.getId() == null) {
//			productRepository.save(productEntity);
//			List<Anh> listImage = productEntity.getListImage();
//			for (Anh imageEntity : listImage) {
//				imageEntity.setProduct(productEntity);
//				imageService.saveOrUpdate(imageEntity);
//			}
//			return "Creat Success";
//		}
//		if(productRepository.findById(productEntity.getId()).isEmpty()) {
//			throw new NoSuchElementException("Not Found productId = " + productEntity.getId());
//		}
//		else {
//			productRepository.save(productEntity);
//			return "Update Success";
//		}
//	}
//
//	@Override
//	public List<SanPham> findAll() {
//		List<SanPham> listProduct = productRepository.findAll();
//		return listProduct;
//	}
//
//	@Override
//	public SanPham findById(Long id) {
//		Optional<SanPham> productEntityOpt = productRepository.findById(id);
//		if(productEntityOpt.isEmpty()) {
//			throw new NoSuchElementException("Not Found productId = " + id);
//		}		
//		return productEntityOpt.get();	
//	}
//
//	@Override
//	public String deleteById(Long id) {
//		Optional<SanPham> productEntityOpt = productRepository.findById(id);
//		if(productEntityOpt.isEmpty()) {
//			return "Not Found";
//		}
//		productRepository.deleteById(id);
//		return "Success";
//	}
//}
