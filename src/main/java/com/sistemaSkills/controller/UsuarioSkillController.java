package com.sistemaSkills.controller;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sistemaSkills.dto.AssociarSkillRequest;
import com.sistemaSkills.dto.UsuarioSkillResponse;
import com.sistemaSkills.entity.UsuarioSkill;
import com.sistemaSkills.service.UsuarioSkillService;

@RestController
@RequestMapping("/usuario-skills")
@CrossOrigin(origins = "*")
public class UsuarioSkillController {
    
    @Autowired
    private UsuarioSkillService usuarioSkillService;
    
    @PostMapping("/associar/{usuarioId}")
    public ResponseEntity<?> associarSkill(@PathVariable Long usuarioId, @RequestBody AssociarSkillRequest request){
        try {
            System.out.println("=== DADOS RECEBIDOS ===");
            System.out.println("Usuario ID: " + usuarioId);
            System.out.println("Skill ID: " + request.getSkillId());
            System.out.println("Nivel: " + request.getNivel());
            
            UsuarioSkill usuarioSkill = usuarioSkillService.associarSkill(usuarioId, request.getSkillId(), request.getNivel());
            UsuarioSkillResponse response = new UsuarioSkillResponse(
                usuarioSkill.getId(),
                usuarioSkill.getUsuario().getId(),
                usuarioSkill.getUsuario().getLogin(),
                usuarioSkill.getSkill().getId(),
                usuarioSkill.getSkill().getNome(),
                usuarioSkill.getNivel(),
                usuarioSkill.getDataAssociacao()
            );
            
            return ResponseEntity.ok(response);
            
        }catch (Exception e) {
            System.err.println("ERRO: " + e.getMessage());
            e.printStackTrace();
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    
    @PutMapping("/atualizar/{usuarioId}")
    public ResponseEntity<?> atualizarNivelSkill(@PathVariable Long usuarioId, @RequestBody AssociarSkillRequest request){
        try {
            UsuarioSkill usuarioSkill = usuarioSkillService.atualizarNivelSkill(usuarioId, request.getSkillId(), request.getNivel());
            
            // Converter para DTO para evitar referência circular
            UsuarioSkillResponse response = new UsuarioSkillResponse(
                usuarioSkill.getId(),
                usuarioSkill.getUsuario().getId(),
                usuarioSkill.getUsuario().getLogin(),
                usuarioSkill.getSkill().getId(),
                usuarioSkill.getSkill().getNome(),
                usuarioSkill.getNivel(),
                usuarioSkill.getDataAssociacao()
            );
            
            return ResponseEntity.ok(response);
        }catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    
    @DeleteMapping("/excluir/{usuarioId}/{skillId}")
    public ResponseEntity<?> excluirAssociacao(
            @PathVariable Long usuarioId,
            @PathVariable Long skillId) {
        try {
            usuarioSkillService.excluirAssociacao(usuarioId, skillId);
            return ResponseEntity.ok("Associação excluída com sucesso");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Erro ao excluir associação: " + e.getMessage());
        }
    }
    
    // ENDPOINT CORRIGIDO - Agora retorna DTO ao invés da entidade
    @GetMapping("/listar/{usuarioId}")
    public ResponseEntity<List<UsuarioSkillResponse>> listarSkillsDoUsuario(@PathVariable Long usuarioId){
        try {
            System.out.println("=== LISTANDO SKILLS DO USUÁRIO ===");
            System.out.println("Usuario ID: " + usuarioId);
            
            List<UsuarioSkill> skills = usuarioSkillService.listarSkillsDoUsuario(usuarioId);
            System.out.println("Número de skills encontradas: " + skills.size());
            
            // Converter para DTO para evitar referência circular
            List<UsuarioSkillResponse> skillsResponse = skills.stream()
                .map(us -> new UsuarioSkillResponse(
                    us.getId(),
                    us.getUsuario().getId(),
                    us.getUsuario().getLogin(),
                    us.getSkill().getId(),
                    us.getSkill().getNome(),
                    us.getNivel(),
                    us.getDataAssociacao()
                ))
                .collect(Collectors.toList());
            
            System.out.println("Skills convertidas para DTO: " + skillsResponse.size());
            return ResponseEntity.ok(skillsResponse);
            
        } catch (Exception e) {
            System.err.println("ERRO ao listar skills: " + e.getMessage());
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }
}