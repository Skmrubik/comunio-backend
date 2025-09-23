package com.example.back_simulador_comunio.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.back_simulador_comunio.controller.ControllerPartido;
import com.example.back_simulador_comunio.entities.JornadasAcumuladas;
import com.example.back_simulador_comunio.entities.Jugador;
import com.example.back_simulador_comunio.entities.Partido;
import com.example.back_simulador_comunio.entities.Puntos;
import com.example.back_simulador_comunio.entities.Resultado;
import com.example.back_simulador_comunio.repositories.JornadasAcumuladasRepository;
import com.example.back_simulador_comunio.repositories.PuntosRepository;


@Service
@RestController
public class JornadasAcumuladasService {

	@Autowired
	JornadasAcumuladasRepository jornadasAcumuladasRepository;
	
	@Autowired
	PuntosRepository puntosRepository;
    
	ControllerPartido controllerPartido;
	
	public JornadasAcumuladasService() {
		this.controllerPartido = new ControllerPartido();
	}
	
	@Transactional
	@PostMapping("/insertPartido")
	public ResponseEntity<Resultado> insertPartido(@RequestBody Partido partido) {
		try {
			//Atributos por defecto
			Resultado result = controllerPartido.generarResultadoPartido(partido);
			JornadasAcumuladas jornadaAcumulada = new JornadasAcumuladas();
			jornadaAcumulada.setIdEquipo1(partido.getEquipoLocal());
			jornadaAcumulada.setIdEquipo2(partido.getEquipoVisitante());
			jornadaAcumulada.setGolesEquipo1(result.getResultadoLocal());
			jornadaAcumulada.setGolesEquipo2(result.getResultadoVisitante());
			jornadaAcumulada.setNumeroJornada(partido.getNumJornada());
			jornadasAcumuladasRepository.save(jornadaAcumulada);
			Resultado resultadoPuntos = controllerPartido.generarPuntosPartido(puntosRepository, partido, result);
			
			return new ResponseEntity<>(result, HttpStatus.OK);
		} catch (Exception e) {
			System.out.println(e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/getPartidosJornada")
	private ResponseEntity<List<JornadasAcumuladas>> getJornada(@RequestParam String numJornada){
		try {
			Integer num = Integer.parseInt(numJornada);
			List<JornadasAcumuladas> partidos = jornadasAcumuladasRepository.findPartidosByNumJornada(num);
			return new ResponseEntity<>(partidos, HttpStatus.OK);
		} catch (Exception e) {
			System.out.println(e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/getPartidoJornada")
	private ResponseEntity<JornadasAcumuladas> getPartidoJornada(@RequestParam String numJornada,
			@RequestParam String idEquipoLocal){
		try {
			Integer num = Integer.parseInt(numJornada);
			Integer idE = Integer.parseInt(idEquipoLocal);
			JornadasAcumuladas partido = jornadasAcumuladasRepository.findPartidoByNumJornadaAndEquipo(num, idE);
			return new ResponseEntity<>(partido, HttpStatus.OK);
		} catch (Exception e) {
			System.out.println(e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/getJugadoresPartidoJornada")
	private ResponseEntity<List<Puntos>> getJugadoresPartidoJornada(@RequestParam String numJornada,
			@RequestParam String equipo){
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
	private ResponseEntity<List<Puntos>> getPuntosJugador(@RequestParam String idJugador){
		try {
			Integer id = Integer.parseInt(idJugador);
			List<Puntos> puntos = puntosRepository.findPuntosJugador(id);
			return new ResponseEntity<>(puntos, HttpStatus.OK);
		} catch (Exception e) {
			System.out.println(e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/borrarTodosDocumentos")
	private ResponseEntity<Integer> borrarTodosDocumentos(){
		try {
			jornadasAcumuladasRepository.deleteAll();
			puntosRepository.deleteAll();
			return new ResponseEntity<>(1, HttpStatus.OK);
		} catch (Exception e) {
			System.out.println(e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
