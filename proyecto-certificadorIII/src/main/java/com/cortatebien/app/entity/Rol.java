package com.cortatebien.app.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;




@Entity
@Table (name = "rol")
public class Rol implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private Integer id_rol; 
	@Column(name = "nombre")
	private String nombre;
	/*
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "idUsuario")
	private List<Usuario> usuario;*/
	

	public String getNombre() {
		return nombre;
	}

	public Integer getId_rol() {
		return id_rol;
	}

	public void setId_rol(Integer id_rol) {
		this.id_rol = id_rol;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/*
	public List<Usuario> getUsuario() {
		return usuario;
	}

	public void setUsuario(List<Usuario> usuario) {
		this.usuario = usuario;
	}

	*/
}
