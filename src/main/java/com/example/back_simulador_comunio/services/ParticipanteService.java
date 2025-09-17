package com.example.back_simulador_comunio.services;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.back_simulador_comunio.config.JWTUtil;
import com.example.back_simulador_comunio.entities.LoginCreds;
import com.example.back_simulador_comunio.entities.Participante;
import com.example.back_simulador_comunio.entities.ParticipanteRegistradoDTO;
import com.example.back_simulador_comunio.entities.ParticipanteToken;
import com.example.back_simulador_comunio.repositories.ParticipanteRepository;

@RestController
public class ParticipanteService {
	
	@Autowired
	ParticipanteRepository participanteRepository;
	
	@Autowired
    private JWTUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private PasswordEncoder passwordEncoder;
	
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
	
	@PostMapping("/api/auth/getAccess")
	private ResponseEntity<ParticipanteToken> getAccess(@RequestBody LoginCreds body){
		try{
			UsernamePasswordAuthenticationToken authInputToken =
                    new UsernamePasswordAuthenticationToken(body.getUsername(), body.getPassword());
            authenticationManager.authenticate(authInputToken);
            Optional<Participante> participante = participanteRepository.findByNickname(body.getUsername());
            
            Participante user = participante.get();
            ParticipanteRegistradoDTO participanteRegistrado = new ParticipanteRegistradoDTO(user.getIdParticipante(),user.getNickname());
            String token = jwtUtil.generateToken(body.getUsername());
            ParticipanteToken participanteToken = new ParticipanteToken(participanteRegistrado, token);
            return new ResponseEntity<>(participanteToken, HttpStatus.OK);
        } catch(Exception e){
        	System.out.println(e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
	}
	
	@GetMapping("/reiniciarJornadaParticipantes")
	private ResponseEntity<Integer> reiniciarJornadaParticipantes(){
		try {
			int a = participanteRepository.aumentarPuntosTotalesParticipante();
			int b = participanteRepository.reiniciarPuntosJornada();
			int c = participanteRepository.reiniciarNumeroJugadores();
			return new ResponseEntity<>(1, HttpStatus.OK);
		} catch (Exception e) {
			System.out.println(e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
