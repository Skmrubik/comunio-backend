package com.example.back_simulador_comunio.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="jornadas_acumuladas")
public class JornadasAcumuladas {
	
	@Id
	@Column(name="id_jornada_acumulada")
	private Integer idJornadaAcumulada;
	
	@Column(name="numero_jornada")
	private Integer numeroJornada;
	
	@ManyToOne
	@JoinColumn(name="id_equipo1")
	private Equipo idEquipo1;
	
	@ManyToOne
	@JoinColumn(name="id_equipo2")
	private Equipo idEquipo2;
	
	@Column(name="goles_equipo1")
	private Integer golesEquipo1;
	
	@Column(name="goles_equipo2")
	private Integer golesEquipo2;
	
	public Integer getIdJornadaAcumulada() {
		return idJornadaAcumulada;
	}

	public void setIdJornadaAcumulada(Integer idJornadaAcumulada) {
		this.idJornadaAcumulada = idJornadaAcumulada;
	}

	public Equipo getIdEquipo1() {
		return idEquipo1;
	}

	public void setIdEquipo1(Equipo idEquipo1) {
		this.idEquipo1 = idEquipo1;
	}

	public Equipo getIdEquipo2() {
		return idEquipo2;
	}

	public void setIdEquipo2(Equipo idEquipo2) {
		this.idEquipo2 = idEquipo2;
	}

	public Integer getNumeroJornada() {
		return numeroJornada;
	}
	public void setNumeroJornada(Integer numeroJornada) {
		this.numeroJornada = numeroJornada;
	}
	
	public Integer getGolesEquipo1() {
		return golesEquipo1;
	}
	public void setGolesEquipo1(Integer golesEquipo1) {
		this.golesEquipo1 = golesEquipo1;
	}
	public Integer getGolesEquipo2() {
		return golesEquipo2;
	}
	public void setGolesEquipo2(Integer golesEquipo2) {
		this.golesEquipo2 = golesEquipo2;
	}

}
