package com.example.back_simulador_comunio.services;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.example.back_simulador_comunio.entities.Jugador;
import com.example.back_simulador_comunio.entities.MensajeJugadorDTO;
import com.example.back_simulador_comunio.repositories.JugadorRepository;
import com.example.back_simulador_comunio.repositories.ParticipanteRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class KafkaConsumerService {

	@Autowired
	JugadorRepository jugadorRepository;
	
	@Autowired
	ParticipanteRepository participanteRepository;
	
	public KafkaConsumerService() {
    }
	
	
    @KafkaListener(topics = "my_topic", groupId = "group_id")
    public void consume(MensajeJugadorDTO obj) {
        
        Jugador jugador = jugadorRepository.getJugadorById(obj.getIdJugador());
        jugador.setGoles(obj.getGoles());
        jugador.setPuntosJornada(obj.getPuntosJornada());
        jugadorRepository.save(jugador);
        if (jugador.getIdParticipante() != null && jugador.getIdParticipante().getIdParticipante() != null && jugador.getTitular()) {
        	participanteRepository.aumentarPuntosJornadaParticipante(obj.getPuntosJornada(), jugador.getIdParticipante().getIdParticipante());
        	if(jugador.getTitular()) {
        		participanteRepository.aumentarJugadoresJugadosParticipante(jugador.getIdParticipante().getIdParticipante());
        	}
        }
        
    }
}