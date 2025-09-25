package com.example.back_simulador_comunio.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.back_simulador_comunio.entities.Equipo;
import com.example.back_simulador_comunio.entities.Estado;
import com.example.back_simulador_comunio.repositories.EstadoRepository;
import com.example.back_simulador_comunio.repositories.JugadorRepository;
import com.example.back_simulador_comunio.repositories.ParticipanteRepository;

@Component
@RestController
public class EstadoService {
	
	@Autowired
	EstadoRepository estadoRepository;
	
	@Autowired
	JugadorRepository jugadorRepository;
	
	@Autowired
	ParticipanteRepository participanteRepository;
	
	@GetMapping("/getEstado")
	private ResponseEntity<Estado> listEstado(){
		try {
			List<Estado> estado = estadoRepository.findAll();
			return new ResponseEntity<>(estado.get(0), HttpStatus.OK);
		} catch (Exception e) {
			System.out.println(e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/siguienteJornada")
	private ResponseEntity<Estado> siguienteJornada(){
		try {
			int sig = estadoRepository.siguienteJornada();
			int part = estadoRepository.reiniciarPartidosJugados();
			List<Estado> estado = estadoRepository.findAll();
			return new ResponseEntity<>(estado.get(0), HttpStatus.OK);
		} catch (Exception e) {
			System.out.println(e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/siguientePartido")
	private ResponseEntity<Estado> siguientePartido(){
		try {
			int sig = estadoRepository.siguientePartido();
			List<Estado> estado = estadoRepository.findAll();
			return new ResponseEntity<>(estado.get(0), HttpStatus.OK);
		} catch (Exception e) {
			System.out.println(e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/reiniciarDatos")
	private ResponseEntity<Integer> reiniciarDatos(){
		try {
			estadoRepository.reiniciarNumJornada();
			estadoRepository.reiniciarPartidosJugados();
			jugadorRepository.reiniciarGolesJornada();
			jugadorRepository.reiniciarNumJornada();
			jugadorRepository.reiniciarPuntosJornada();
			jugadorRepository.reiniciarPuntosTotales();
			jugadorRepository.reiniciarPuntosMedia();
			participanteRepository.reiniciarNumeroJugadores();
			participanteRepository.reiniciarPuntosJornada();
			participanteRepository.reiniciarPuntosTotales();
			return new ResponseEntity<>(1, HttpStatus.OK);
		} catch (Exception e) {
			System.out.println(e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
