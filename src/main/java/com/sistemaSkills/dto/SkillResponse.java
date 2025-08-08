package com.sistemaSkills.dto;

import java.time.LocalDateTime;

public class SkillResponse {
 private Long id;
 private String nome;
 private String descricao;
 private LocalDateTime dataCadastro;
 
 public SkillResponse(Long id, String nome, String descricao, LocalDateTime dataCadastro) {
     this.id = id;
     this.nome = nome;
     this.descricao = descricao;
     this.dataCadastro = dataCadastro;
 }

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
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

public LocalDateTime getDataCadastro() {
	return dataCadastro;
}

public void setDataCadastro(LocalDateTime dataCadastro) {
	this.dataCadastro = dataCadastro;
}
 
 // getters e setters...
}