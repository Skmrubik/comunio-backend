package com.example.back_simulador_comunio.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.example.back_simulador_comunio.entities.Jugador;
import com.example.back_simulador_comunio.entities.JugadorEquipoDTO;

import jakarta.transaction.Transactional;

public interface JugadorRepository extends JpaRepository<Jugador, Integer>{
	
	@Query(value="select * from jugador where id_participante = ?1 and titular = true order by posicion", nativeQuery=true)
	public List<Jugador> listJugadoresPorParticipante(Integer idParticipante);

	@Query(value="select j.id_jugador, j.nombre, j.puntos_totales, j.puntos_media, j.posicion, j.puntos_jornada, e.path_foto, j.goles from jugador j \r\n"
			+ "inner join equipo e on j.id_equipo = e.id_equipo \r\n"
			+ "where id_participante = ?1 and titular = true order by j.posicion", nativeQuery = true)
	public List<JugadorEquipoDTO> listJugadoresTitulares(Integer idParticipante);
	
	@Query(value="select j.id_jugador, j.nombre, j.puntos_totales, j.puntos_media, j.posicion, j.puntos_jornada, e.path_foto from jugador j\r\n"
			+ "inner join equipo e on j.id_equipo = e.id_equipo\r\n"
			+ "where id_participante = ?1 and titular = false order by j.posicion", nativeQuery = true)
	public List<JugadorEquipoDTO> listJugadoresSuplentes(Integer idParticipante);
	
	@Query(value="select j.id_jugador, j.nombre, j.puntos_totales, j.puntos_media, j.posicion, j.puntos_jornada, e.path_foto, j.goles from jugador j\r\n"
			+ "inner join equipo e on j.id_equipo = e.id_equipo\r\n"
			+ "where id_participante = ?1 and titular = false and j.posicion = ?2", nativeQuery = true)
	public List<JugadorEquipoDTO> listJugadoresSuplentesPosicion(Integer idParticipante, Integer posicion);
	
	@Query(value="select * from jugador where id_equipo = ?1 order by posicion", nativeQuery=true)
	public List<Jugador> listJugadoresEquipo(Integer idEquipo);
	
	@Query(value="select * from jugador where id_jugador = ?1", nativeQuery=true)
	public Jugador getJugadorById(Integer id);
	
	@Modifying
    @Transactional
    @Query(value="update jugador set puntos_totales = puntos_totales + puntos_jornada", nativeQuery=true)
    int sumarJornadaATotal();
	
	@Modifying
    @Transactional
    @Query(value="update jugador set titular = false where id_jugador = ?1", nativeQuery=true)
    int updateJugadorASuplente(Integer idJugador);
	
	@Modifying
    @Transactional
    @Query(value="update jugador set titular = true where id_jugador = ?1", nativeQuery=true)
    int updateJugadorATitular(Integer idJugador);
	
	@Modifying
    @Transactional
    @Query(value="update jugador set puntos_jornada = 0", nativeQuery=true)
    int reiniciarPuntosJornada();
	
	@Modifying
    @Transactional
    @Query(value="update jugador set goles = 0", nativeQuery=true)
    int reiniciarGolesJornada();
	
	@Modifying
    @Transactional
    @Query(value="update jugador set puntos_media = 0", nativeQuery=true)
    int reiniciarPuntosMedia();
	
	@Modifying
    @Transactional
    @Query(value="update jugador set puntos_totales = 0", nativeQuery=true)
    int reiniciarPuntosTotales();
	
	@Modifying
    @Transactional
    @Query(value="update jugador set num_jornada = 1", nativeQuery=true)
    int reiniciarNumJornada();
	
	@Modifying
    @Transactional
    @Query(value="update jugador set puntos_media = round(puntos_totales/num_jornada,1)", nativeQuery=true)
    int calcularMedia();
	
	@Modifying
    @Transactional
    @Query(value="update jugador set num_jornada = num_jornada + 1", nativeQuery=true)
    int aumentarJornada();
	
}
