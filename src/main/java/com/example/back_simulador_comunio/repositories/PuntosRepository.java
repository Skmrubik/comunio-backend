package com.example.back_simulador_comunio.repositories;

import com.example.back_simulador_comunio.entities.Puntos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PuntosRepository extends JpaRepository<Puntos, Integer>{
    @Query(value= "select * from puntos where num_jornada = ?1 and id_equipo = ?2 order by posicion desc", nativeQuery = true)
    public List<Puntos> findJugadoresEquipoJornada(Integer numJornada, Integer idEquipo);

    @Query(value="select * from puntos where id_jugador = ?1 order by num_jornada desc", nativeQuery = true)
    public List<Puntos> findPuntosJugador(Integer idJugador);
}
