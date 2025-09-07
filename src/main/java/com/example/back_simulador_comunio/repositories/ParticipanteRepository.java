package com.example.back_simulador_comunio.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.back_simulador_comunio.entities.Participante;

public interface ParticipanteRepository extends JpaRepository<Participante, Integer>{

	@Query(value="select * from participante order by puntos_totales desc", nativeQuery=true)
	public List<Participante> getClasificacion();
}
