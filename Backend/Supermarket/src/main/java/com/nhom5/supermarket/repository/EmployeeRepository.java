package com.nhom5.supermarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nhom5.supermarket.entity.EmployeeEntity;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long>{

}
