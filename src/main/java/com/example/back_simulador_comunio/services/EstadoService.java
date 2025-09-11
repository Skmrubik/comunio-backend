package com.example.back_simulador_comunio.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.back_simulador_comunio.entities.Equipo;
import com.example.back_simulador_comunio.entities.Estado;
import com.example.back_simulador_comunio.repositories.EstadoRepository;

@RestController
public class EstadoService {
	
	@Autowired
	EstadoRepository estadoRepository;
	
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
}
