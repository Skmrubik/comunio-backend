package com.example.back_simulador_comunio.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.back_simulador_comunio.entities.Jugador;
import com.example.back_simulador_comunio.entities.JugadorEquipoDTO;
import com.example.back_simulador_comunio.repositories.JugadorRepository;

@RestController
public class JugadorService {
	
	@Autowired
	JugadorRepository jugadorRepository;
	
	@GetMapping("/listJugadores")
	private ResponseEntity<List<Jugador>> listJugadores(){
		try {
			List<Jugador> jugador = jugadorRepository.findAll();
			return new ResponseEntity<>(jugador, HttpStatus.OK);
		} catch (Exception e) {
			System.out.println(e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/listJugadoresPorParticipante")
	private ResponseEntity<List<Jugador>> listJugadoresPorParticipante(@RequestParam String idParticipante){
		try {
			Integer id = Integer.parseInt(idParticipante);
			List<Jugador> jugador = jugadorRepository.listJugadoresPorParticipante(id);
			return new ResponseEntity<>(jugador, HttpStatus.OK);
		} catch (Exception e) {
			System.out.println(e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/listJugadoresPorEquipo")
	private ResponseEntity<List<Jugador>> listJugadoresPorEquipo(@RequestParam String idEquipo){
		try {
			Integer id = Integer.parseInt(idEquipo);
			List<Jugador> jugador = jugadorRepository.listJugadoresEquipo(id);
			return new ResponseEntity<>(jugador, HttpStatus.OK);
		} catch (Exception e) {
			System.out.println(e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/listJugadoresTitulares")
	private ResponseEntity<List<JugadorEquipoDTO>> listJugadoresTitulares(@RequestParam String idParticipante){
		try {
			Integer id = Integer.parseInt(idParticipante);
			List<JugadorEquipoDTO> jugador = jugadorRepository.listJugadoresTitulares(id);
			return new ResponseEntity<>(jugador, HttpStatus.OK);
		} catch (Exception e) {
			System.out.println(e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/listJugadoresSuplentes")
	private ResponseEntity<List<JugadorEquipoDTO>> listJugadoresSuplentes(@RequestParam String idParticipante){
		try {
			Integer id = Integer.parseInt(idParticipante);
			List<JugadorEquipoDTO> jugador = jugadorRepository.listJugadoresSuplentes(id);
			return new ResponseEntity<>(jugador, HttpStatus.OK);
		} catch (Exception e) {
			System.out.println(e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
