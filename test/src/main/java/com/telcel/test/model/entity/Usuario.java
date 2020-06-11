package com.telcel.test.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "tusuario")
public class Usuario implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5926391667268215448L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String nombre;
	private String a_paterno;
	private String a_materno;
	
	@ManyToOne
	@JoinColumn(name= "idTrole") 
	private Role id_trole;
		
	public Usuario() {
	}

	public Usuario(int id, String nombre, String a_paterno, String a_materno, Role id_trole) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.a_paterno = a_paterno;
		this.a_materno = a_materno;
		this.id_trole = id_trole;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getA_paterno() {
		return a_paterno;
	}
	public void setA_paterno(String a_paterno) {
		this.a_paterno = a_paterno;
	}
	public String getA_materno() {
		return a_materno;
	}
	public void setA_materno(String a_materno) {
		this.a_materno = a_materno;
	}
	public Role getId_trole() {
		return id_trole;
	}

	public void setId_trole(Role id_trole) {
		this.id_trole = id_trole;
	}
	
	
}
