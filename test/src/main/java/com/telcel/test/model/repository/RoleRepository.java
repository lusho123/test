package com.telcel.test.model.repository;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.telcel.test.model.entity.Role;

@Transactional
@Repository
public interface RoleRepository extends CrudRepository<Role, Integer> {

	public Optional<Role> findByNombre(String nombre);
	
}
