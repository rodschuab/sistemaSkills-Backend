package com.sistemaSkills.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.*;

@Entity
@Table(name ="usuarios")
public class Usuario  {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique = true, nullable = false)
	private String login;
	
	@Column(nullable = false)
	@JsonIgnore
	private String senha;
	
	@Column(name = "data_cadastro")
	private LocalDateTime dataCadastro;
	
	@OneToMany (mappedBy = "usuario", cascade = CascadeType.ALL)
	private Set<UsuarioSkill> skills = new HashSet<>();
	
	public Usuario() {
		this.dataCadastro = LocalDateTime.now();
		}

	 public Usuario(String login, String senha) {
	        this();
	        this.login = login;
	        this.senha = senha;
	 }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public LocalDateTime getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(LocalDateTime dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Set<UsuarioSkill> getSkills() {
		return skills;
	}

	public void setSkills(Set<UsuarioSkill> skills) {
		this.skills = skills;
	}

	   
	    
	}