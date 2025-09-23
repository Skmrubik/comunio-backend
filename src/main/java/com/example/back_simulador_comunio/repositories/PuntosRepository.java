package com.example.back_simulador_comunio.repositories;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.back_simulador_comunio.entities.Puntos;



@Repository
public interface PuntosRepository extends JpaRepository<Puntos, Integer>{
	
	@Query(value = "select * from puntos where num_jornada = ?1 and id_equipo = ?2 order by posicion desc", nativeQuery = true)
    List<Puntos> findJugadoresEquipoJornada(Integer numJornada, Integer idEquipo);
	
	@Query(value = "select * from puntos where id_jugador = ?1 order by num_jornada desc", nativeQuery=true)
    List<Puntos> findPuntosJugador(Integer idjugador);
}
