//package com.nhom5.supermarket.service.imp;
//
//import java.util.List;
//import java.util.NoSuchElementException;
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.nhom5.supermarket.entity.NhaCungCap;
//import com.nhom5.supermarket.repository.SupplierRepository;
//import com.nhom5.supermarket.service.AddressService;
//import com.nhom5.supermarket.service.SupplierService;
//@Service
//public class SupplierServiceImp implements SupplierService{
//
//	@Autowired
//	private SupplierRepository supplierRepository;
//	
//	@Autowired
//	private AddressService addressService;
//	
//	@Override
//	public String saveOrUpdate(NhaCungCap supplierEntity) {
//		if(supplierEntity.getId() == null) {
//			addressService.saveOrUpdate(supplierEntity.getAddress());
//			supplierRepository.save(supplierEntity);
//			return "Creat Success";
//		}
//		if(supplierRepository.findById(supplierEntity.getId()).isEmpty()) {
//			throw new NoSuchElementException("Not Found supplierId = " + supplierEntity.getId());
//		}
//		else {
//			supplierRepository.save(supplierEntity);
//			return "Update Success";
//		}
//	}
//
//	@Override
//	public List<NhaCungCap> findAll() {
//		return supplierRepository.findAll();
//	}
//
//	@Override
//	public NhaCungCap findById(Long id) {
//		Optional<NhaCungCap> supplierEntityOpt = supplierRepository.findById(id);
//		if(supplierEntityOpt.isEmpty()) {
//			throw new NoSuchElementException("Not Found supplierId = " + id);
//		}
//		return supplierEntityOpt.get();	
//	}
//
//	@Override
//	public String deleteById(Long id) {
//		Optional<NhaCungCap> supplierEntityOpt = supplierRepository.findById(id);
//		if(supplierEntityOpt.isEmpty()) {
//			return "Not Found";
//		}
//		supplierRepository.deleteById(id);
//		return "Success";
//	}
//}
