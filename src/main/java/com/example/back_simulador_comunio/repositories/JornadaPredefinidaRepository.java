package com.example.back_simulador_comunio.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.back_simulador_comunio.entities.JornadaPredefinida;

public interface JornadaPredefinidaRepository extends JpaRepository<JornadaPredefinida, Integer>{
	
	@Query(value="select * from jornada_predefinida where num_jornada = ?1 order by id_jornada_predefinida", nativeQuery=true)
	public List<JornadaPredefinida> getPartidosJornada(Integer jornada);

}
