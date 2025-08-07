package com.sistemaSkills.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "skills")
public class Skill {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique = true, nullable = false)
	private String nome;
	
	private String descricao;
	
	@Column (name= "data_cadastro")
	private LocalDateTime dataCadastro;
	
	@OneToMany(mappedBy = "skill", cascade = CascadeType.ALL)
	private Set<UsuarioSkill> usuarios = new HashSet<>();
	
	public Skill() {
		this.dataCadastro = LocalDateTime.now();
	}

	public Skill(String nome, String descricao) {
		this();
		this.nome = nome;
		this.descricao = descricao;
		
		
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

	public Set<UsuarioSkill> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(Set<UsuarioSkill> usuarios) {
		this.usuarios = usuarios;
	}
	
	
	
	
	

}
