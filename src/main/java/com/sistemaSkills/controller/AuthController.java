package com.sistemaSkills.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sistemaSkills.dto.CadastroRequest;
import com.sistemaSkills.dto.LoginRequest;
import com.sistemaSkills.dto.TokenResponse;
import com.sistemaSkills.entity.Usuario;
import com.sistemaSkills.security.JwtUtil;
import com.sistemaSkills.service.UsuarioService;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "*")
public class AuthController {
    
    @Autowired
    private UsuarioService usuarioService;
    
    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        try {
            Usuario usuario = usuarioService.buscarPorLogin(loginRequest.getLogin());
            
            if (usuario == null) {
                return ResponseEntity.badRequest().body("Usuário não encontrado");
            }
            
            if (!usuarioService.verificarSenha(loginRequest.getSenha(), usuario.getSenha())) {
                return ResponseEntity.badRequest().body("Senha incorreta");
            }

            String token = jwtUtil.gerarToken(usuario.getLogin());
            return ResponseEntity.ok(new TokenResponse(token, usuario.getId(), usuario.getLogin()));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Erro no login: " + e.getMessage());
        }
    }

    @PostMapping("/cadastro")
    public ResponseEntity<?> cadastro(@RequestBody CadastroRequest cadastroRequest) {
        try {
            Usuario usuario = usuarioService.criarUsuario(
                cadastroRequest.getLogin(), 
                cadastroRequest.getSenha()
            );
            
            String token = jwtUtil.gerarToken(usuario.getLogin());
            return ResponseEntity.ok(new TokenResponse(token, usuario.getId(), usuario.getLogin()));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Erro no cadastro: " + e.getMessage());
        }
    }
}