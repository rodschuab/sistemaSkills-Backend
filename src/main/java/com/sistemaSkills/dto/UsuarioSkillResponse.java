package com.sistemaSkills.dto;

import java.time.LocalDateTime;

public class UsuarioSkillResponse {
    private Long id;
    private Long usuarioId;
    private String usuarioLogin;
    private Long skillId;
    private String skillNome;
    private Integer nivel;
    private LocalDateTime dataAssociacao;
    
    public UsuarioSkillResponse() {}

	public UsuarioSkillResponse(Long id, Long usuarioId, String usuarioLogin, Long skillId, String skillNome,
			Integer nivel, LocalDateTime dataAssociacao) {
		this.id = id;
		this.usuarioId = usuarioId;
		this.usuarioLogin = usuarioLogin;
		this.skillId = skillId;
		this.skillNome = skillNome;
		this.nivel = nivel;
		this.dataAssociacao = dataAssociacao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(Long usuarioId) {
		this.usuarioId = usuarioId;
	}

	public String getUsuarioLogin() {
		return usuarioLogin;
	}

	public void setUsuarioLogin(String usuarioLogin) {
		this.usuarioLogin = usuarioLogin;
	}

	public Long getSkillId() {
		return skillId;
	}

	public void setSkillId(Long skillId) {
		this.skillId = skillId;
	}

	public String getSkillNome() {
		return skillNome;
	}

	public void setSkillNome(String skillNome) {
		this.skillNome = skillNome;
	}

	public Integer getNivel() {
		return nivel;
	}

	public void setNivel(Integer nivel) {
		this.nivel = nivel;
	}

	public LocalDateTime getDataAssociacao() {
		return dataAssociacao;
	}

	public void setDataAssociacao(LocalDateTime dataAssociacao) {
		this.dataAssociacao = dataAssociacao;
	}
    
	
    
}