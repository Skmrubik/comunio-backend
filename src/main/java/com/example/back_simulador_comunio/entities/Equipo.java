package com.example.back_simulador_comunio.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "equipo")
public class Equipo {
	
	@Id
	@Column(name="id_equipo")
	private Integer idEquipo;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="path_foto")
	private String pathFoto;
	
	@Column(name="nivel")
	private Float nivel;
	
	@Column(name="goles_casa")
	private Integer golesCasa;

	@Column(name="goles_fuera")
	private Integer golesFuera;
	
	public Integer getIdEquipo() {
		return idEquipo;
	}

	public void setIdEquipo(Integer idEquipo) {
		this.idEquipo = idEquipo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPathFoto() {
		return pathFoto;
	}

	public void setPathFoto(String pathFoto) {
		this.pathFoto = pathFoto;
	}

	public Float getNivel() {
		return nivel;
	}

	public void setNivel(Float nivel) {
		this.nivel = nivel;
	}

	public Integer getGolesCasa() {
		return golesCasa;
	}

	public void setGolesCasa(Integer golesCasa) {
		this.golesCasa = golesCasa;
	}

	public Integer getGolesFuera() {
		return golesFuera;
	}

	public void setGolesFuera(Integer golesFuera) {
		this.golesFuera = golesFuera;
	}
}
