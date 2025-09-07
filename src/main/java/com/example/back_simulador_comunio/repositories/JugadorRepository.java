package com.example.back_simulador_comunio.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.back_simulador_comunio.entities.Jugador;

public interface JugadorRepository extends JpaRepository<Jugador, Integer>{
	
	@Query(value="select * from jugador where id_participante = ?1 and titular = true order by posicion", nativeQuery=true)
	public List<Jugador> listJugadoresPorParticipante(Integer idParticipante);

}
