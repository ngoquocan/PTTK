package com.nhom5.supermarket.service.imp;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nhom5.supermarket.entity.RoleEntity;
import com.nhom5.supermarket.repository.RoleRepository;
import com.nhom5.supermarket.service.RoleService;
@Service
public class RoleServiceImp implements RoleService{

	@Autowired
	private RoleRepository roleRepository;
	@Override
	public String saveOrUpdate(RoleEntity roleEntity) {
		if(roleEntity.getId() == null) {
			roleRepository.save(roleEntity);
			return "Creat Success";
		}
		if(roleRepository.findById(roleEntity.getId()).isEmpty()) {
			throw new NoSuchElementException("Not Found roleId = " + roleEntity.getId());
		}
		else {
			roleRepository.save(roleEntity);
			return "Update Success";
		}
	}

	@Override
	public List<RoleEntity> findAll() {
		return roleRepository.findAll();
	}

	@Override
	public RoleEntity findById(Long id) {
		Optional<RoleEntity> roleEntityOpt = roleRepository.findById(id);
		if(roleEntityOpt.isEmpty()) {
			throw new NoSuchElementException("Not Found roleId = " + id);
		}
		return roleEntityOpt.get();	
	}

	@Override
	public String deleteById(Long id) {
		Optional<RoleEntity> roleEntityOpt = roleRepository.findById(id);
		if(roleEntityOpt.isEmpty()) {
			return "Not Found";
		}
		roleRepository.deleteById(id);
		return "Success";
	}
}
