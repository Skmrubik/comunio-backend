package com.example.back_simulador_comunio.entities;

public class ParticipanteRegistradoDTO {
	Integer idParticipante;
	String nickname;
	
	public ParticipanteRegistradoDTO(Integer idParticipante, String nickname) {
		this.idParticipante = idParticipante;
		this.nickname = nickname;
	}
	
	public ParticipanteRegistradoDTO() {
	}

	public Integer getIdParticipante() {
		return idParticipante;
	}
	public void setIdParticipante(Integer idParticipante) {
		this.idParticipante = idParticipante;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
}
