package com.sistemaSkills.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistemaSkills.entity.Usuario;

import java.util.Optional;


public interface UsuarioRepository extends JpaRepository <Usuario, Long>{
	
	Optional<Usuario> findByLogin(String login);
	boolean existsByLogin(String login);

}
