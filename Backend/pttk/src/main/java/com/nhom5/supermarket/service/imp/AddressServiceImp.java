//package com.nhom5.supermarket.service.imp;
//
//import java.util.List;
//import java.util.NoSuchElementException;
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.nhom5.supermarket.entity.DiaChi;
//import com.nhom5.supermarket.repository.AddressRepository;
//import com.nhom5.supermarket.service.AddressService;
//
//@Service
//public class AddressServiceImp implements AddressService{
//
//	@Autowired
//	private AddressRepository addressRepository;
//	@Override
//	public String saveOrUpdate(DiaChi addressEntity) {
//		if(addressEntity.getId() == null) {
//			addressRepository.save(addressEntity);
//			return "Creat Success";
//		}
//		if(addressRepository.findById(addressEntity.getId()).isEmpty()) {
//			throw new NoSuchElementException("Not Found addressId = " + addressEntity.getId());
//		}
//		else {
//			addressRepository.save(addressEntity);
//			return "Update Success";
//		}
//	}
//
//	@Override
//	public List<DiaChi> findAll() {
//		return addressRepository.findAll();
//	}
//
//	@Override
//	public DiaChi findById(Long id) {
//		Optional<DiaChi> addressEntityOpt = addressRepository.findById(id);
//		if(addressEntityOpt.isEmpty()) {
//			throw new NoSuchElementException("Not Found addressId = " + id);
//		}
//		return addressEntityOpt.get();	
//	}
//
//	@Override
//	public String deleteById(Long id) {
//		Optional<DiaChi> addressEntityOpt = addressRepository.findById(id);
//		if(addressEntityOpt.isEmpty()) {
//			return "Not Found";
//		}
//		addressRepository.deleteById(id);
//		return "Success";
//	}
//}
