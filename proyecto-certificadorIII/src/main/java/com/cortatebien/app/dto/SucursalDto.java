package com.cortatebien.app.dto;

import java.util.ArrayList;
import java.util.List;

import com.cortatebien.app.entity.Direccion;
import com.cortatebien.app.entity.Horario;

public class SucursalDto {

	private String razon_social;
	private Integer ruc;
	private String nombre; 
	private String telefono; 
	private Integer id_usuario;
	private List<Horario> horario = new ArrayList<Horario>();
	private Direccion direccion;
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
	public Integer getId_usuario() {
		return id_usuario;
	}
	public void setId_usuario(Integer id_usuario) {
		this.id_usuario = id_usuario;
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
