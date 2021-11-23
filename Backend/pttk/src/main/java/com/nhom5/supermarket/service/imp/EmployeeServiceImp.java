//package com.nhom5.supermarket.service.imp;
//
//import java.util.List;
//import java.util.NoSuchElementException;
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.nhom5.supermarket.entity.GioHang;
//import com.nhom5.supermarket.entity.NhanVien;
//import com.nhom5.supermarket.repository.EmployeeRepository;
//import com.nhom5.supermarket.service.AddressService;
//import com.nhom5.supermarket.service.CartService;
//import com.nhom5.supermarket.service.EmployeeService;
//@Service
//public class EmployeeServiceImp implements EmployeeService{
//
//	@Autowired
//	private EmployeeRepository employeeRepository;
//	
//	@Autowired
//	private CartService cartService;
//	
//	@Autowired
//	private AddressService addressService;
//	
//	@Override
//	public String saveOrUpdate(NhanVien employeeEntity) {
//		if(employeeEntity.getId() == null) {
//			addressService.saveOrUpdate(employeeEntity.getAddress());
//			employeeRepository.save(employeeEntity);
//			
//			return "Creat Success";
//		}
//		if(employeeRepository.findById(employeeEntity.getId()).isEmpty()) {
//			throw new NoSuchElementException("Not Found employeeId = " + employeeEntity.getId());
//		}
//		else {
//			employeeRepository.save(employeeEntity);
//			return "Update Success";
//		}
//	}
//
//	@Override
//	public List<NhanVien> findAll() {
//		return employeeRepository.findAll();
//	}
//
//	@Override
//	public NhanVien findById(Long id) {
//		Optional<NhanVien> employeeEntityOpt = employeeRepository.findById(id);
//		if(employeeEntityOpt.isEmpty()) {
//			throw new NoSuchElementException("Not Found employeeId = " + id);
//		}
//		return employeeEntityOpt.get();	
//	}
//
//	@Override
//	public String deleteById(Long id) {
//		Optional<NhanVien> employeeEntityOpt = employeeRepository.findById(id);
//		if(employeeEntityOpt.isEmpty()) {
//			return "Not Found";
//		}
//		employeeRepository.deleteById(id);
//		return "Success";
//	}
//}
