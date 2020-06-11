package com.telcel.test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.telcel.test.model.entity.Role;
import com.telcel.test.model.entity.Usuario;
import com.telcel.test.model.repository.RoleRepository;
import com.telcel.test.model.repository.UsuarioRepository;


@Service
public class TestService {
	
	@Autowired
	private UsuarioRepository usuario;
	@Autowired
	private RoleRepository role;
	
	
	public List<Usuario> getTodos() {
		return (List<Usuario>) usuario.findAll();
	}
	
	public Usuario getId(int id) {
		return usuario.findById(id).orElse(null);
	}
	
	public Usuario getNombre(String nombre) {
		System.out.println("Nombre");
		return buscarNomUsuario(getTodos(), nombre);
		//return usuario.findByNombre(nombre).orElse(null);
	}
	
	public List<Role> getRoles() {
		return (List<Role>) role.findAll();
	}

	public Role getRoleId(int id) {
		return role.findById(id).orElse(null);
	}

	public Role getRoleNombre(String nombre) {
		return buscarNomRole(getRoles(), nombre);
		//return role.findByNombre(nombre).orElse(null);
	}
	
	public Usuario saveUsuario(Usuario usuarioPost) {
		Usuario auxU = new Usuario();
		int idR = usuarioPost.getId_trole().getId();
		auxU.setA_materno(usuarioPost.getA_materno());
		auxU.setA_paterno(usuarioPost.getA_paterno());
		auxU.setNombre(usuarioPost.getNombre());

		auxU.setId_trole(getRole(idR));
		return usuario.save(auxU);
	}
	
	public Usuario updateUsuario(int id, Usuario usuario) {
		Usuario aux = this.usuario.findById(id).orElse(null);
		int idR = usuario.getId_trole().getId();
		Role auxR = this.role.findById(idR).orElse(null);
		aux.setA_materno(usuario.getA_materno());
		aux.setA_paterno(usuario.getA_paterno());
		aux.setNombre(usuario.getNombre());
		aux.setId_trole(auxR);
		return this.usuario.save(aux);
	}
	
	public void deleteUsuario(int id) {
		usuario.deleteById(id);
	}
	
	private Role getRole(int id) {
		return  this.role.findById(id).orElse(null);
	}
	
	private Usuario buscarNomUsuario(List<Usuario> usuarios, String nombre) {
		for (Usuario usuario : usuarios) {
			if (nombre.compareTo(usuario.getNombre()) == 0) {
				return usuario;
			}
		}
		return null;
	}
	
	private Role buscarNomRole(List<Role> roles, String nombre) {
		for (Role rol : roles) {
			if (nombre.compareTo(rol.getNombre()) == 0) {
				return rol;
			}
		}
		return null;
	}

	
	
}
