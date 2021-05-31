package com.cortatebien.app.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table (name = "Horario")
public class Horario implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_horario;
	
	private String dia;
	@Temporal(TemporalType.TIME)
	private Date hora_inicio; 
	@Temporal(TemporalType.TIME)
	private Date hora_final;
	public Integer getId_horario() {
		return id_horario;
	}
	public void setId_horario(Integer id_horario) {
		this.id_horario = id_horario;
	}

	public String getDia() {
		return dia;
	}

	public void setDia(String dia) {
		this.dia = dia;
	}
	public Date getHora_inicio() {
		return hora_inicio;
	}
	public void setHora_inicio(Date hora_inicio) {
		this.hora_inicio = hora_inicio;
	}
	public Date getHora_final() {
		return hora_final;
	}
	public void setHora_final(Date hora_final) {
		this.hora_final = hora_final;
	}

	
}
