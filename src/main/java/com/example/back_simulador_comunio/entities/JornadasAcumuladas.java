package com.example.back_simulador_comunio.entities;

import jakarta.persistence.*;

@Entity
@Table(name="jornadas_acumuladas")
public class JornadasAcumuladas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_jornadas_acumuladas")
    private Integer idJornadasAcumuladas;

    @Column(name="numero_jornada")
    private Integer numeroJornada;

    @ManyToOne
    @JoinColumn(name="id_equipo_uno")
    private Equipo idEquipoUno;

    @ManyToOne
    @JoinColumn(name="id_equipo_dos")
    private Equipo idEquipoDos;

    @Column(name="goles_equipo_uno")
    private Integer golesEquipoUno;

    @Column(name="goles_equipo_dos")
    private Integer golesEquipoDos;

    public Integer getIdJornadaAcumulada() {
        return idJornadasAcumuladas;
    }

    public void setIdJornadaAcumulada(Integer idJornadaAcumulada) {
        this.idJornadasAcumuladas = idJornadaAcumulada;
    }

    public Integer getNumeroJornada() {
        return numeroJornada;
    }

    public void setNumeroJornada(Integer numeroJornada) {
        this.numeroJornada = numeroJornada;
    }

    public Equipo getIdEquipoUno() {
        return idEquipoUno;
    }

    public void setIdEquipoUno(Equipo idEquipoUno) {
        this.idEquipoUno = idEquipoUno;
    }

    public Equipo getIdEquipoDos() {
        return idEquipoDos;
    }

    public void setIdEquipoDos(Equipo idEquipoDos) {
        this.idEquipoDos = idEquipoDos;
    }

    public Integer getGolesEquipoUno() {
        return golesEquipoUno;
    }

    public void setGolesEquipoUno(Integer golesEquipoUno) {
        this.golesEquipoUno = golesEquipoUno;
    }

    public Integer getGolesEquipoDos() {
        return golesEquipoDos;
    }

    public void setGolesEquipoDos(Integer golesEquipoDos) {
        this.golesEquipoDos = golesEquipoDos;
    }
}
