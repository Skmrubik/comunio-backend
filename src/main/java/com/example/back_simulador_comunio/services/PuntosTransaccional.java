package com.example.back_simulador_comunio.services;

import com.example.back_simulador_comunio.repositories.PuntosRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PuntosTransaccional {

    @Autowired
    PuntosRepository puntosRepository;

    @Transactional
    public void borrarPuntos() {
        puntosRepository.deleteAll();
    }
}
