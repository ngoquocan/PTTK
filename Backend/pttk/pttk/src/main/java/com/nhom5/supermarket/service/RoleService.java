package com.nhom5.supermarket.service;

import java.util.List;

import com.example.demo.entity.Role;

public interface RoleService{
	public String saveOrUpdate(Role roleEntity);

	public List<Role> findAll();

	public Role findById(Long id);

	public String deleteById(Long id);
}
