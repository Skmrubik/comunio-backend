package com.example.back_simulador_comunio.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="jugador")
public class Jugador {
	
	@Id
	@Column(name="id_jugador")
	private Integer idJugador;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="puntos_totales")
	private Integer puntosTotales;
	
	@Column(name="puntos_media")
	private Float puntosMedia;
	
	@Column(name="puntos_jornada")
	private Integer puntosJornada;
	
	@Column(name="path_foto")
	private String pathFoto;
	
	@ManyToOne
	@JoinColumn(name="id_equipo")
	private Equipo idEquipo;
	
	@ManyToOne
	@JoinColumn(name="id_participante")
	private Participante idParticipante;
	
	@Column(name="posicion")
	private Integer posicion;
	
	@Column(name="titular")
	private Boolean titular;
	
	@Column(name="nivel")
	private Float nivel;
	
	@Column(name="prob_gol")
	private Float probGol;
	
	@Column(name="goles")
	private Integer goles;

	public Integer getIdJugador() {
		return idJugador;
	}

	public void setIdJugador(Integer idJugador) {
		this.idJugador = idJugador;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getPuntosTotales() {
		return puntosTotales;
	}

	public void setPuntosTotales(Integer puntosTotales) {
		this.puntosTotales = puntosTotales;
	}

	public Float getPuntosMedia() {
		return puntosMedia;
	}

	public void setPuntosMedia(Float puntosMedia) {
		this.puntosMedia = puntosMedia;
	}

	public String getPathFoto() {
		return pathFoto;
	}

	public void setPathFoto(String pathFoto) {
		this.pathFoto = pathFoto;
	}

	public Equipo getIdEquipo() {
		return idEquipo;
	}

	public void setIdEquipo(Equipo idEquipo) {
		this.idEquipo = idEquipo;
	}

	public Participante getIdParticipante() {
		return idParticipante;
	}

	public void setIdParticipante(Participante idParticipante) {
		this.idParticipante = idParticipante;
	}

	public Integer getPosicion() {
		return posicion;
	}

	public void setPosicion(Integer posicion) {
		this.posicion = posicion;
	}

	public Boolean getTitular() {
		return titular;
	}

	public void setTitular(Boolean titular) {
		this.titular = titular;
	}

	public Float getNivel() {
		return nivel;
	}

	public void setNivel(Float nivel) {
		this.nivel = nivel;
	}

	public Float getProbGol() {
		return probGol;
	}

	public void setProbGol(Float probGol) {
		this.probGol = probGol;
	}

	public Integer getPuntosJornada() {
		return puntosJornada;
	}

	public void setPuntosJornada(Integer puntosJornada) {
		this.puntosJornada = puntosJornada;
	}

	public Integer getGoles() {
		return goles;
	}

	public void setGoles(Integer goles) {
		this.goles = goles;
	}
	
}
