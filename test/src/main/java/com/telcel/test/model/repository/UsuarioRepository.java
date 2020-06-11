package com.telcel.test.model.repository;

import java.util.Optional;

import javax.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

import com.telcel.test.model.entity.Usuario;

@Transactional
@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Integer> {

	public Optional<Usuario> findByNombre(String nom);
	
}
