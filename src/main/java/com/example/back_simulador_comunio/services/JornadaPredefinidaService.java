package com.example.back_simulador_comunio.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.back_simulador_comunio.entities.JornadaPredefinida;
import com.example.back_simulador_comunio.repositories.JornadaPredefinidaRepository;

@RestController
public class JornadaPredefinidaService {
	
	@Autowired
	JornadaPredefinidaRepository jornadaPredefinidaRepository;
	
	@GetMapping("/listJornadasPredefindas")
	private ResponseEntity<List<JornadaPredefinida>> listJornadasPredefinidas(){
		try {
			List<JornadaPredefinida> jornadas = jornadaPredefinidaRepository.findAll();
			return new ResponseEntity<>(jornadas, HttpStatus.OK);
		} catch (Exception e) {
			System.out.println(e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/getJornada")
	private ResponseEntity<List<JornadaPredefinida>> getJornada(@RequestParam String numJornada){
		try {
			Integer num = Integer.parseInt(numJornada);
			Integer jornadaCalculada = (num-1)%10;
			List<JornadaPredefinida> jornada = jornadaPredefinidaRepository.getPartidosJornada(jornadaCalculada);
			return new ResponseEntity<>(jornada, HttpStatus.OK);
		} catch (Exception e) {
			System.out.println(e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
