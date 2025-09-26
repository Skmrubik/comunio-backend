package com.example.back_simulador_comunio.entities;

import jakarta.persistence.*;

@Entity
@Table(name="puntos")
public class Puntos {
    @Id
    @Column(name="id_puntos")
    private Integer idPuntos;

    @ManyToOne
    @JoinColumn(name="id_jugador")
    private Jugador idJugador;

    @Column(name="nombre")
    private String nombre;

    @Column(name="puntos_jornada")
    private Integer puntosJornada;

    @Column(name="goles")
    private Integer goles;

    @Column(name="num_jornada")
    private Integer numJornada;

    @ManyToOne
    @JoinColumn(name="id_equipo")
    private Equipo idEquipo;

    @Column(name="posicion")
    private Integer posicion;

    public Integer getIdPuntos() {
        return idPuntos;
    }

    public void setIdPuntos(Integer idPuntos) {
        this.idPuntos = idPuntos;
    }

    public Jugador getIdJugador() {
        return idJugador;
    }

    public void setIdJugador(Jugador idJugador) {
        this.idJugador = idJugador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public Integer getNumJornada() {
        return numJornada;
    }

    public void setNumJornada(Integer numJornada) {
        this.numJornada = numJornada;
    }

    public Equipo getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(Equipo idEquipo) {
        this.idEquipo = idEquipo;
    }

    public Integer getPosicion() {
        return posicion;
    }

    public void setPosicion(Integer posicion) {
        this.posicion = posicion;
    }
}
