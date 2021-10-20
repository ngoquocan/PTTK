package com.nhom5.supermarket.service.imp;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nhom5.supermarket.entity.ImageEntity;
import com.nhom5.supermarket.repository.ImageRepository;
import com.nhom5.supermarket.service.ImageService;
@Service
public class ImageServiceImp implements ImageService{

	@Autowired
	private ImageRepository imageRepository;
	@Override
	public String saveOrUpdate(ImageEntity imageEntity) {
		if(imageEntity.getId() == null) {
			imageRepository.save(imageEntity);
			return "Creat Success";
		}
		if(imageRepository.findById(imageEntity.getId()).isEmpty()) {
			throw new NoSuchElementException("Not Found imageId = " + imageEntity.getId());
		}
		else {
			imageRepository.save(imageEntity);
			return "Update Success";
		}
	}

	@Override
	public List<ImageEntity> findAll() {
		return imageRepository.findAll();
	}

	@Override
	public ImageEntity findById(Long id) {
		Optional<ImageEntity> imageEntityOpt = imageRepository.findById(id);
		if(imageEntityOpt.isEmpty()) {
			throw new NoSuchElementException("Not Found imageId = " + id);
		}
		return imageEntityOpt.get();	
	}

	@Override
	public String deleteById(Long id) {
		Optional<ImageEntity> imageEntityOpt = imageRepository.findById(id);
		if(imageEntityOpt.isEmpty()) {
			return "Not Found";
		}
		imageRepository.deleteById(id);
		return "Success";
	}

	@Override
	public List<ImageEntity> findByProductId(Long id) {
		return imageRepository.findByProductId(id);
	}
}
