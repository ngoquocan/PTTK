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
//import com.nhom5.supermarket.repository.ImageRepository;
//import com.nhom5.supermarket.service.ImageService;
//@Service
//public class ImageServiceImp implements ImageService{
//
//	@Autowired
//	private ImageRepository imageRepository;
//	@Override
//	public String saveOrUpdate(Anh imageEntity) {
//		if(imageEntity.getId() == null) {
//			imageRepository.save(imageEntity);
//			return "Creat Success";
//		}
//		if(imageRepository.findById(imageEntity.getId()).isEmpty()) {
//			throw new NoSuchElementException("Not Found imageId = " + imageEntity.getId());
//		}
//		else {
//			imageRepository.save(imageEntity);
//			return "Update Success";
//		}
//	}
//
//	@Override
//	public List<Anh> findAll() {
//		return imageRepository.findAll();
//	}
//
//	@Override
//	public Anh findById(Long id) {
//		Optional<Anh> imageEntityOpt = imageRepository.findById(id);
//		if(imageEntityOpt.isEmpty()) {
//			throw new NoSuchElementException("Not Found imageId = " + id);
//		}
//		return imageEntityOpt.get();	
//	}
//
//	@Override
//	public String deleteById(Long id) {
//		Optional<Anh> imageEntityOpt = imageRepository.findById(id);
//		if(imageEntityOpt.isEmpty()) {
//			return "Not Found";
//		}
//		imageRepository.deleteById(id);
//		return "Success";
//	}
//
//	@Override
//	public List<Anh> findByProductId(Long id) {
//		return imageRepository.findByProductId(id);
//	}
//}
