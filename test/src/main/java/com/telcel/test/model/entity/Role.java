package com.telcel.test.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "trole")
public class Role implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2133219428635678656L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int idTrole;
	private String nombre;
		
	public Role() {
	}

	public Role(int idTrole, String nombre) {
		super();
		this.idTrole = idTrole;
		this.nombre = nombre;
	}

	public int getId() {
		return idTrole;
	}
	public void setId(int idTrole) {
		this.idTrole = idTrole;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	
	

}
