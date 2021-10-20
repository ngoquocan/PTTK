package com.nhom5.supermarket.service;

import java.util.List;

import com.nhom5.supermarket.entity.RoleEntity;

public interface RoleService{
	public String saveOrUpdate(RoleEntity roleEntity);

	public List<RoleEntity> findAll();

	public RoleEntity findById(Long id);

	public String deleteById(Long id);
}
