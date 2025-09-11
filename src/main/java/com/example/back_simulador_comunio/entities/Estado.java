package com.example.back_simulador_comunio.entities;

import jakarta.persistence.Id;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="estado")
public class Estado {
	
	@Id
	@Column(name="id_estado")
	private Integer idEstado;
	
	@Column(name="num_jornada")
	private Integer numJornada;
	
	@Column(name="fin_jornada")
	private Boolean finJornada;

	public Integer getIdEstado() {
		return idEstado;
	}

	public void setIdEstado(Integer idEstado) {
		this.idEstado = idEstado;
	}

	public Integer getNumJornada() {
		return numJornada;
	}

	public void setNumJornada(Integer numJornada) {
		this.numJornada = numJornada;
	}

	public Boolean getFinJornada() {
		return finJornada;
	}

	public void setFinJornada(Boolean finJornada) {
		this.finJornada = finJornada;
	}
	
	
}
