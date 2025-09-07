package com.example.back_simulador_comunio.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="jornadaPredefinida")
public class JornadaPredefinida {
	
	@Id
	@Column(name="id_jornada_predefinida")
	private Integer idJornadaPredefinida;
	
	@Column(name="num_jornada")
	private Integer numJornada;
	
	@ManyToOne
	@JoinColumn(name="id_equipo_local")
	private Equipo idEquipoLocal;
	
	@ManyToOne
	@JoinColumn(name="id_equipo_visitante")
	private Equipo idEquipoVisitante;

	public Integer getIdJornadaPredefinida() {
		return idJornadaPredefinida;
	}

	public void setIdJornadaPredefinida(Integer idJornadaPredefinida) {
		this.idJornadaPredefinida = idJornadaPredefinida;
	}

	public Integer getNumJornada() {
		return numJornada;
	}

	public void setNumJornada(Integer numJornada) {
		this.numJornada = numJornada;
	}

	public Equipo getIdEquipoLocal() {
		return idEquipoLocal;
	}

	public void setIdEquipoLocal(Equipo idEquipoLocal) {
		this.idEquipoLocal = idEquipoLocal;
	}

	public Equipo getIdEquipoVisitante() {
		return idEquipoVisitante;
	}

	public void setIdEquipoVisitante(Equipo idEquipoVisitante) {
		this.idEquipoVisitante = idEquipoVisitante;
	}
}
