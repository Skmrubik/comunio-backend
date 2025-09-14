package com.example.back_simulador_comunio.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.example.back_simulador_comunio.entities.Participante;



public interface ParticipanteRepository extends JpaRepository<Participante, Integer>{

	@Query(value="select * from participante order by puntos_jornada_actual desc", nativeQuery=true)
	public List<Participante> getClasificacion();
	
	@Query(value="select * from participante order by puntos_totales desc", nativeQuery=true)
	public List<Participante> getClasificacionTotal();
	
	public Participante findByNickname(String nickname);
	
	@Modifying
    @Transactional
    @Query(value="update participante set puntos_jornada_actual = puntos_jornada_actual + ?1 \r\n"
    		+ "where id_participante = ?2", nativeQuery=true)
    int aumentarPuntosJornadaParticipante(Integer puntos, Integer idParticipante);
	
	@Modifying
    @Transactional
    @Query(value="update participante set jugadores_jugados = jugadores_jugados + 1 \r\n"
    		+ "where id_participante = ?1", nativeQuery=true)
    int aumentarJugadoresJugadosParticipante(Integer idParticipante);
	
	@Modifying
    @Transactional
    @Query(value="update participante set puntos_totales = puntos_totales + puntos_jornada_actual", nativeQuery=true)
    int aumentarPuntosTotalesParticipante();
	
	@Modifying
    @Transactional
    @Query(value="update participante set puntos_jornada_actual = 0", nativeQuery=true)
    int reiniciarPuntosJornada();
	
	@Modifying
    @Transactional
    @Query(value="update participante set jugadores_jugados = 0", nativeQuery=true)
    int reiniciarNumeroJugadores();
}
