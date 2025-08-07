package com.sistemaSkills.dto;

public class TokenResponse {
	private String token;
	private Long usuarioId;
	private String login;
	
	public TokenResponse(String token, Long usuarioId, String login) {

		this.token = token;
		this.usuarioId = usuarioId;
		this.login = login;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Long getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(Long usuarioId) {
		this.usuarioId = usuarioId;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}
	
	

}
