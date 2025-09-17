package com.example.back_simulador_comunio.entities;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="participante")
public class Participante {
	
	@Id
	@Column(name = "id_participante")
	private Integer idParticipante;
	
	@Column(name = "nickname")
	private String nickname;
	
	@Column(name = "puntos_totales")
	private Integer puntosTotales;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "puntos_jornada_actual")
	private Integer puntosJornadaActual;
	
	@Column(name = "jugadores_jugados")
	private Integer jugadoresJugados;

	public Integer getIdParticipante() {
		return idParticipante;
	}

	public void setIdParticipante(Integer idParticipante) {
		this.idParticipante = idParticipante;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public Integer getPuntosTotales() {
		return puntosTotales;
	}

	public void setPuntosTotales(Integer puntosTotales) {
		this.puntosTotales = puntosTotales;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getPuntosJornadaActual() {
		return puntosJornadaActual;
	}

	public void setPuntosJornadaActual(Integer puntosJornadaActual) {
		this.puntosJornadaActual = puntosJornadaActual;
	}

	public Integer getJugadoresJugados() {
		return jugadoresJugados;
	}

	public void setJugadoresJugados(Integer jugadoresJugados) {
		this.jugadoresJugados = jugadoresJugados;
	}
	
}
