package com.example.back_simulador_comunio.entities;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

public class JugadorEquipoDTO {

	private Integer id_jugador;
	
	private String nombre;
	
	private BigDecimal puntos_totales;
	
	private BigDecimal puntos_media;
	
	private Integer posicion;
	
	private Integer puntos_jornada;
	
	private String path_foto;
	
	private Integer goles;

	public JugadorEquipoDTO() {
	}

	public JugadorEquipoDTO(Integer id_jugador, String nombre, BigDecimal puntos_totales, BigDecimal puntos_media,
			Integer posicion, Integer puntos_jornada, String path_foto, Integer goles) {
		this.id_jugador = id_jugador;
		this.nombre = nombre;
		this.puntos_totales = puntos_totales;
		this.puntos_media = puntos_media;
		this.posicion = posicion;
		this.puntos_jornada = puntos_jornada;
		this.path_foto = path_foto;
		this.goles = goles;
	}

	public Integer getId_jugador() {
		return id_jugador;
	}

	public void setId_jugador(Integer id_jugador) {
		this.id_jugador = id_jugador;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public BigDecimal getPuntos_totales() {
		return puntos_totales;
	}

	public void setPuntos_totales(BigDecimal puntos_totales) {
		this.puntos_totales = puntos_totales;
	}

	public BigDecimal getPuntos_media() {
		return puntos_media;
	}

	public void setPuntos_media(BigDecimal puntos_media) {
		this.puntos_media = puntos_media;
	}

	public Integer getPosicion() {
		return posicion;
	}

	public void setPosicion(Integer posicion) {
		this.posicion = posicion;
	}

	public Integer getPuntos_jornada() {
		return puntos_jornada;
	}

	public void setPuntos_jornada(Integer puntos_jornada) {
		this.puntos_jornada = puntos_jornada;
	}

	public String getPath_foto() {
		return path_foto;
	}

	public void setPath_foto(String path_foto) {
		this.path_foto = path_foto;
	}
	public Integer getGoles() {
		return goles;
	}

	public void setGoles(Integer goles) {
		this.goles = goles;
	}
}
