package com.example.back_simulador_comunio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.example.back_simulador_comunio.entities.Estado;

import jakarta.transaction.Transactional;

public interface EstadoRepository extends JpaRepository<Estado, Integer>{

	@Modifying
    @Transactional
    @Query(value="update estado set num_jornada = num_jornada + 1", nativeQuery=true)
    int siguienteJornada();
	
	@Modifying
    @Transactional
    @Query(value="update estado set partidos_jugados = partidos_jugados + 1", nativeQuery=true)
    int siguientePartido();
	
	@Modifying
    @Transactional
    @Query(value="update estado set partidos_jugados = 0", nativeQuery=true)
    int reiniciarPartidosJugados();
	
	@Modifying
    @Transactional
    @Query(value="update estado set num_jornada = 1", nativeQuery=true)
    int reiniciarNumJornada();
}
