package com.example.back_simulador_comunio.services;

import com.example.back_simulador_comunio.repositories.JornadasAcumuladasRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JornadasAcumuladasTransaccional {
    @Autowired
    JornadasAcumuladasRepository jornadasAcumuladasRepository;

    @Transactional
    public void borrarTodasJornadas() {
        jornadasAcumuladasRepository.deleteAll();
    }
}
