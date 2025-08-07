package com.sistemaSkills.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.sistemaSkills.entity.Usuario;
import com.sistemaSkills.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public Usuario buscarPorLogin(String login) {
		return usuarioRepository.findByLogin(login)
				.orElse(null);
	}
	
	public Usuario criarUsuario(String login, String senha) {
		if (usuarioRepository.existsByLogin(login)) {
			throw new RuntimeException("Login já existe");
		}
		
		Usuario usuario = new Usuario (login, passwordEncoder.encode(senha));
		return usuarioRepository.save(usuario);
	}
	
	public Usuario buscarPorId(Long id) {
		return usuarioRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Usuario não encontrado"));
	}

	public boolean verificarSenha(String senhaDigitada, String senhaHash) {
		return passwordEncoder.matches(senhaDigitada, senhaHash);
	}

}
