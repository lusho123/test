package com.telcel.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.telcel.test.model.entity.Role;
import com.telcel.test.model.entity.Usuario;
import com.telcel.test.service.TestService;

@RestController
@RequestMapping("api")
@CrossOrigin
public class TestController {

	@Autowired
	private TestService servicio;
	
	@GetMapping("/usuarios")
	public List<Usuario> getUsuarios () {
		return servicio.getTodos();
	}
	
	@GetMapping("/usuario/{id}")
	public Usuario getUsuarioId(@PathVariable int id) {
		return servicio.getId(id);
	}
	
	@GetMapping("/usuario/nombre/{nombre}")
	public Usuario getUsuarioNombre(@PathVariable String nombre) {
		return servicio.getNombre(nombre);
	}
	
	@GetMapping("/roles")
	public List<Role> getRoles() {
		return servicio.getRoles();
	}
	
	@GetMapping("/role/{id}")
	public Role getRoleId(@PathVariable int id) {
		return servicio.getRoleId(id);
	}
	
	@GetMapping("/role/nombre/{nombre}")
	public Role getRoleNombre(@PathVariable String nombre) {
		return servicio.getRoleNombre(nombre);
	}
	
	
	@PostMapping("/usuario")
	public Usuario postUsuario(@RequestBody Usuario usuario) {
		return servicio.saveUsuario(usuario);
	}
	
	@PutMapping("/usuario/{id}")
	public Usuario updateUsuario(@RequestBody Usuario usuario, @PathVariable int id) {
		return servicio.updateUsuario(id, usuario);
	}
	
	@DeleteMapping("/usuario/{id}")
	public void deleteUsuario(@PathVariable int id) {
		servicio.deleteUsuario(id);
	}
 	
	
}
