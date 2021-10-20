package com.nhom5.supermarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nhom5.supermarket.entity.AddressEntity;

public interface AddressRepository extends JpaRepository<AddressEntity, Long>{

}
