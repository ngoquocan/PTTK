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
//import com.nhom5.supermarket.entity.KhachHang;
//import com.nhom5.supermarket.entity.Role;
//import com.nhom5.supermarket.repository.CustomerRepository;
//import com.nhom5.supermarket.service.AddressService;
//import com.nhom5.supermarket.service.CartService;
//import com.nhom5.supermarket.service.CustomerService;
//import com.nhom5.supermarket.service.RoleService;
//@Service
//public class CustomerServiceImp implements CustomerService{
//
//	@Autowired
//	private CustomerRepository customerRepository;
//	
//	@Autowired
//	private CartService cartService;
//	
//	@Autowired
//	private AddressService addressService;
//	
//	@Autowired
//	private RoleService roleService;
//	
//	@Override
//	public String saveOrUpdate(KhachHang customerEntity) {
//		if(customerEntity.getId() == null) {
//			addressService.saveOrUpdate(customerEntity.getAddress());
//			customerEntity.setRole(roleService.findById((long) 3));
//			customerRepository.save(customerEntity);
//			
//			cartService.saveOrUpdate(new GioHang(customerEntity));
//			
//			return "Creat Success";
//		}
//		if(customerRepository.findById(customerEntity.getId()).isEmpty()) {
//			throw new NoSuchElementException("Not Found customerId = " + customerEntity.getId());
//		}
//		else {
//			customerRepository.save(customerEntity);
//			return "Update Success";
//		}
//	}
//
//	@Override
//	public List<KhachHang> findAll() {
//		return customerRepository.findAll();
//	}
//
//	@Override
//	public KhachHang findById(Long id) {
//		Optional<KhachHang> customerEntityOpt = customerRepository.findById(id);
//		if(customerEntityOpt.isEmpty()) {
//			throw new NoSuchElementException("Not Found customerId = " + id);
//		}
//		return customerEntityOpt.get();	
//	}
//
//	@Override
//	public String deleteById(Long id) {
//		Optional<KhachHang> customerEntityOpt = customerRepository.findById(id);
//		if(customerEntityOpt.isEmpty()) {
//			return "Not Found";
//		}
//		customerRepository.deleteById(id);
//		return "Success";
//	}
//}
//
