package com.example.back_simulador_comunio.repositories;

import com.example.back_simulador_comunio.entities.JornadasAcumuladas;
import org.springframework.lang.Nullable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Repository
public interface JornadasAcumuladasRepository extends JpaRepository<JornadasAcumuladas, Integer> {

    @Query(value="select * from jornadas_acumuladas where numero_jornada = ?1", nativeQuery = true)
    public List<JornadasAcumuladas> findPartidosByNumJornada(Integer numJornada);

    @Query(value="select * from jornadas_acumuladas where numero_jornada = ?1 and id_equipo_uno = ?2", nativeQuery = true)
    public JornadasAcumuladas findPartidoByNumJornadaAndEquipo(Integer numJornada, Integer idEquipoLocal);
}
