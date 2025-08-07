package com.sistemaSkills.dto;

public class SkillRequest {
	private String nome;
	private String descricao;
	
	public SkillRequest() {}

	public SkillRequest(String nome, String descricao) {
		super();
		this.nome = nome;
		this.descricao = descricao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
}
