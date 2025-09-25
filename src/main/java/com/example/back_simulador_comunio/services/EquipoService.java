package com.example.back_simulador_comunio.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.back_simulador_comunio.entities.Equipo;
import com.example.back_simulador_comunio.repositories.EquipoRepository;
@Component
@RestController
public class EquipoService {

	@Autowired
	EquipoRepository equipoRepository;
	
	@GetMapping("/listEquipos")
	private ResponseEntity<List<Equipo>> listEquipos(){
		try {
			List<Equipo> equipos = equipoRepository.findAll();
			return new ResponseEntity<>(equipos, HttpStatus.OK);
		} catch (Exception e) {
			System.out.println(e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
