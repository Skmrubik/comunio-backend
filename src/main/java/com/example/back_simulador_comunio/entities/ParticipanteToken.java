package com.example.back_simulador_comunio.entities;

public class ParticipanteToken {
	
	private ParticipanteRegistradoDTO participante;
	private String jwt_token;
	
	public ParticipanteToken(ParticipanteRegistradoDTO participante, String jwt_token) {
		this.participante = participante;
		this.jwt_token = jwt_token;
	}
	
	public ParticipanteToken() {
	}

	public ParticipanteRegistradoDTO getParticipante() {
		return participante;
	}

	public void setParticipante(ParticipanteRegistradoDTO participante) {
		this.participante = participante;
	}

	public String getJwt_token() {
		return jwt_token;
	}

	public void setJwt_token(String jwt_token) {
		this.jwt_token = jwt_token;
	}
}
