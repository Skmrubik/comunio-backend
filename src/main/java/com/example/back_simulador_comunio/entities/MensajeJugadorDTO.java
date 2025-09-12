package com.example.back_simulador_comunio.entities;

import java.io.Serializable;

public class MensajeJugadorDTO implements Serializable{
	Integer idJugador;
	Integer puntosJornada;
	Integer goles;
	
	
	public MensajeJugadorDTO() {
	}

	public MensajeJugadorDTO(Integer idJugador, Integer puntosJornada, Integer goles) {
		this.idJugador = idJugador;
		this.puntosJornada = puntosJornada;
		this.goles = goles;
	}
	
	public Integer getIdJugador() {
		return idJugador;
	}
	public void setIdJugador(Integer idJugador) {
		this.idJugador = idJugador;
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
