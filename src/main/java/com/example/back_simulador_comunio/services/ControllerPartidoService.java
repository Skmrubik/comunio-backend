package com.example.back_simulador_comunio.services;

import com.example.back_simulador_comunio.controller.ControllerPartido;
import com.example.back_simulador_comunio.entities.JornadasAcumuladas;
import com.example.back_simulador_comunio.entities.Partido;
import com.example.back_simulador_comunio.entities.Resultado;
import com.example.back_simulador_comunio.repositories.PuntosRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ControllerPartidoService {

    @Autowired
    ControllerPartido controllerPartido;

    @Transactional
    public JornadasAcumuladas generarPartido(Partido partido, Resultado result) {
        return controllerPartido.generarJornada(partido, result);
    }

    @Transactional
    public Resultado generarPuntosPartido(PuntosRepository puntosRepository, Partido partido, Resultado result) throws JsonProcessingException {
        return controllerPartido.generarPuntosPartido(puntosRepository, partido, result);
    }
    @Transactional
    public Resultado generarResultadoPartido(Partido partido){
        return controllerPartido.generarResultadoPartido(partido);
    }

}
