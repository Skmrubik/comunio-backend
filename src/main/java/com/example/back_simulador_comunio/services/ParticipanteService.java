package com.example.back_simulador_comunio.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.back_simulador_comunio.entities.Participante;
import com.example.back_simulador_comunio.repositories.ParticipanteRepository;

@RestController
public class ParticipanteService {
	@Autowired
	ParticipanteRepository participanteRepository;
	
	@GetMapping("/listParticipantes")
	private ResponseEntity<List<Participante>> listParticipantes(){
		try {
			List<Participante> participante = participanteRepository.findAll();
			return new ResponseEntity<>(participante, HttpStatus.OK);
		} catch (Exception e) {
			System.out.println(e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/getClasificacion")
	private ResponseEntity<List<Participante>> getClasificacionOrdenada(){
		try {
			List<Participante> participante = participanteRepository.getClasificacion();
			return new ResponseEntity<>(participante, HttpStatus.OK);
		} catch (Exception e) {
			System.out.println(e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/getClasificacionTotal")
	private ResponseEntity<List<Participante>> getClasificacionOrdenadaTotal(){
		try {
			List<Participante> participante = participanteRepository.getClasificacionTotal();
			return new ResponseEntity<>(participante, HttpStatus.OK);
		} catch (Exception e) {
			System.out.println(e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/getAccess")
	private ResponseEntity<Participante> getAccess(@RequestParam String username,
			@RequestParam String password){
		try {
			Participante participante = participanteRepository.findByNickname(username);
			Participante participanteVacio = new Participante();
			if (participante.getPassword().equals(password)) {
				return new ResponseEntity<>(participante, HttpStatus.OK);
			}
			else {
				return new ResponseEntity<>(participanteVacio, HttpStatus.OK); 
			}
		} catch (Exception e) {
			System.out.println(e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/reiniciarJornadaParticipantes")
	private ResponseEntity<Integer> reiniciarJornadaParticipantes(){
		try {
			int a = participanteRepository.aumentarPuntosTotalesParticipante();
			int b = participanteRepository.reiniciarPuntosJornada();
			return new ResponseEntity<>(1, HttpStatus.OK);
		} catch (Exception e) {
			System.out.println(e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
