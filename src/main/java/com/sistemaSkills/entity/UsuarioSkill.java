package com.sistemaSkills.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name ="usuario_skill")
public class UsuarioSkill {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name ="usuario_id")
	@JsonIgnore
	private Usuario usuario;
	
	@ManyToOne
	@JoinColumn(name ="skill_id")
	private Skill skill;
	
	private Integer nivel;
	
	@Column(name="data_associacao")
	private LocalDateTime dataAssociacao;
	
	public UsuarioSkill() {
		this.dataAssociacao = LocalDateTime.now();
	}

	public UsuarioSkill( Usuario usuario, Skill skill, Integer nivel) {
		this();
		this.usuario = usuario;
		this.skill = skill;
		this.nivel = nivel;
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Skill getSkill() {
		return skill;
	}

	public void setSkill(Skill skill) {
		this.skill = skill;
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
