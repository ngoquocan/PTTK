package com.nhom5.supermarket.service.imp;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nhom5.supermarket.entity.CartEntity;
import com.nhom5.supermarket.entity.CustomerEntity;
import com.nhom5.supermarket.entity.RoleEntity;
import com.nhom5.supermarket.repository.CustomerRepository;
import com.nhom5.supermarket.service.AddressService;
import com.nhom5.supermarket.service.CartService;
import com.nhom5.supermarket.service.CustomerService;
import com.nhom5.supermarket.service.RoleService;
@Service
public class CustomerServiceImp implements CustomerService{

	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private CartService cartService;
	
	@Autowired
	private AddressService addressService;
	
	@Autowired
	private RoleService roleService;
	
	@Override
	public String saveOrUpdate(CustomerEntity customerEntity) {
		if(customerEntity.getId() == null) {
			addressService.saveOrUpdate(customerEntity.getAddress());
			customerEntity.setRole(roleService.findById((long) 3));
			customerRepository.save(customerEntity);
			
			cartService.saveOrUpdate(new CartEntity(customerEntity));
			
			return "Creat Success";
		}
		if(customerRepository.findById(customerEntity.getId()).isEmpty()) {
			throw new NoSuchElementException("Not Found customerId = " + customerEntity.getId());
		}
		else {
			customerRepository.save(customerEntity);
			return "Update Success";
		}
	}

	@Override
	public List<CustomerEntity> findAll() {
		return customerRepository.findAll();
	}

	@Override
	public CustomerEntity findById(Long id) {
		Optional<CustomerEntity> customerEntityOpt = customerRepository.findById(id);
		if(customerEntityOpt.isEmpty()) {
			throw new NoSuchElementException("Not Found customerId = " + id);
		}
		return customerEntityOpt.get();	
	}

	@Override
	public String deleteById(Long id) {
		Optional<CustomerEntity> customerEntityOpt = customerRepository.findById(id);
		if(customerEntityOpt.isEmpty()) {
			return "Not Found";
		}
		customerRepository.deleteById(id);
		return "Success";
	}
}

