package com.example.back_simulador_comunio.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.back_simulador_comunio.entities.JornadasAcumuladas;
import org.springframework.stereotype.Repository;

@Repository
public interface JornadasAcumuladasRepository extends JpaRepository<JornadasAcumuladas, Integer>{
	@Query(value="select * from jornadas_acumuladas where numero_jornada = ?1", nativeQuery=true)
    public List<JornadasAcumuladas> findPartidosByNumJornada(Integer numJornada);
	
	@Query(value="select * from jornadas_acumuladas where numero_jornada = ?1 and id_equipo1 = ?2", nativeQuery= true)
    public JornadasAcumuladas findPartidoByNumJornadaAndEquipo(Integer numJornada, Integer idEquipoLocal);
}
