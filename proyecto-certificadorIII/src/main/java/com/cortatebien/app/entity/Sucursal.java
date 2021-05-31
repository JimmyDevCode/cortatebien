package com.cortatebien.app.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table (name = "Sucursal")

public class Sucursal {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_sucursal;
	private String razon_social;
	private Integer ruc;
	private String nombre; 
	private String telefono; 
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_usuario")
	private Usuario usuario;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_horario")
	private List<Horario> horario = new ArrayList<Horario>();
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_direccion")
	private Direccion direccion;
	
	public Integer getId_sucursal() {
		return id_sucursal;
	}

	public void setId_sucursal(Integer id_sucursal) {
		this.id_sucursal = id_sucursal;
	}

	public String getRazon_social() {
		return razon_social;
	}

	public void setRazon_social(String razon_social) {
		this.razon_social = razon_social;
	}

	public Integer getRuc() {
		return ruc;
	}

	public void setRuc(Integer ruc) {
		this.ruc = ruc;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Horario> getHorario() {
		return horario;
	}

	public void setHorario(List<Horario> horario) {
		this.horario = horario;
	}

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}
	
	
}
