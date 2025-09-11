package com.example.back_simulador_comunio.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.back_simulador_comunio.entities.Jugador;
import com.example.back_simulador_comunio.entities.JugadorEquipoDTO;

public interface JugadorRepository extends JpaRepository<Jugador, Integer>{
	
	@Query(value="select * from jugador where id_participante = ?1 and titular = true order by posicion", nativeQuery=true)
	public List<Jugador> listJugadoresPorParticipante(Integer idParticipante);

	@Query(value="select j.id_jugador, j.nombre, j.puntos_totales, j.puntos_media, j.posicion, j.puntos_jornada, e.path_foto from jugador j \r\n"
			+ "inner join equipo e on j.id_equipo = e.id_equipo \r\n"
			+ "where id_participante = ?1 and titular = true order by j.posicion", nativeQuery = true)
	public List<JugadorEquipoDTO> listJugadoresTitulares(Integer idParticipante);
	
	@Query(value="select j.id_jugador, j.nombre, j.puntos_totales, j.puntos_media, j.posicion, j.puntos_jornada, e.path_foto from jugador j\r\n"
			+ "inner join equipo e on j.id_equipo = e.id_equipo\r\n"
			+ "where id_participante = ?1 and titular = false order by j.posicion", nativeQuery = true)
	public List<JugadorEquipoDTO> listJugadoresSuplentes(Integer idParticipante);
	
	@Query(value="select * from jugador where id_equipo = ?1 order by posicion", nativeQuery=true)
	public List<Jugador> listJugadoresEquipo(Integer idEquipo);
}
