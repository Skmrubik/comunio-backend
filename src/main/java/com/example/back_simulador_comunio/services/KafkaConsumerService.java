package com.example.back_simulador_comunio.services;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.example.back_simulador_comunio.entities.Jugador;
import com.example.back_simulador_comunio.entities.MensajeJugadorDTO;
import com.example.back_simulador_comunio.repositories.JugadorRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class KafkaConsumerService {

	@Autowired
	JugadorRepository jugadorRepository;
	
	private final WebSocketHandler webSocketHandler;
	
	public KafkaConsumerService(WebSocketHandler webSocketHandler) {
        this.webSocketHandler = webSocketHandler;
    }
	
	static int contador = 0;
	
    @KafkaListener(topics = "my_topic", groupId = "group_id")
    public void consume(MensajeJugadorDTO obj) {

		System.out.println("IdJugador: " + obj.getIdJugador());
	    System.out.println("Puntos: " + obj.getPuntosJornada());
	    System.out.println("Goles: " + obj.getGoles());
	    System.out.println("-------------------------");
        
        Jugador jugador = jugadorRepository.getJugadorById(obj.getIdJugador());
        jugador.setGoles(obj.getGoles());
        jugador.setPuntosJornada(obj.getPuntosJornada());
        jugadorRepository.save(jugador);
        contador++;
        if (contador == 22) {
        	
        	try {
        		Thread.sleep(2000);
				webSocketHandler.sendMessage("UPDATE");
			} catch (IOException | InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	contador = 0;
        }
    }
}