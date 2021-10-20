package com.nhom5.supermarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nhom5.supermarket.entity.CustomerEntity;

public interface CustomerRepository extends JpaRepository<CustomerEntity, Long>{

}
