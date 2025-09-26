package com.example.back_simulador_comunio.services;

import com.example.back_simulador_comunio.entities.Puntos;
import com.example.back_simulador_comunio.repositories.PuntosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.graphql.GraphQlProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PuntosService {

    @Autowired
    PuntosRepository puntosRepository;

    @GetMapping("/getJugadoresPartidoJornada")
    private ResponseEntity<List<Puntos>> getJugadoresPartidoJornada(@RequestParam String numJornada, @RequestParam String equipo) {
        try {
            Integer num = Integer.parseInt(numJornada);
            Integer eq = Integer.parseInt(equipo);
            List<Puntos> puntos = puntosRepository.findJugadoresEquipoJornada(num, eq);
            return new ResponseEntity<>(puntos, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getPuntosJugador")
    private ResponseEntity<List<Puntos>> getPuntosJugador(@RequestParam String idJugador) {
        try {
            Integer jug = Integer.parseInt(idJugador);
            List<Puntos> puntos = puntosRepository.findPuntosJugador(jug);
            return new ResponseEntity<>(puntos, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/borrarTodosDocumentosPuntos")
    private ResponseEntity<Integer> borrarTodosDocumentos() {
        try {
            puntosRepository.deleteAll();
            return new ResponseEntity<>(1, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
