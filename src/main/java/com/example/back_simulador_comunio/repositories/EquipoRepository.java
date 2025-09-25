package com.example.back_simulador_comunio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.back_simulador_comunio.entities.Equipo;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipoRepository extends JpaRepository<Equipo, Integer>{

}
