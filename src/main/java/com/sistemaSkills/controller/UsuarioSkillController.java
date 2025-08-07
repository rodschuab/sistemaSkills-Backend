package com.sistemaSkills.controller;

import java.util.List;

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
import com.sistemaSkills.entity.UsuarioSkill;
import com.sistemaSkills.service.UsuarioSkillService;

@RestController
@RequestMapping("/usuario-skills")
@CrossOrigin(origins = "*")
public class UsuarioSkillController {
	
	@Autowired
	private UsuarioSkillService usuarioSkillService;
	
	@PostMapping("associar/{usuarioId}")
	public ResponseEntity<?> associarSkill(@PathVariable Long usuarioId, @RequestBody AssociarSkillRequest request){
		
		try {
			UsuarioSkill usuarioSkill = usuarioSkillService.associarSkill(usuarioId, request.getSkillId(), request.getNivel());
			return ResponseEntity.ok(usuarioSkill);
		}catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	
	}
	
	@PutMapping("/atualizar/{usuarioId}")
	public ResponseEntity<?> atualizarNivelSkill(@PathVariable Long usuarioId, @RequestBody AssociarSkillRequest request){
		try {
			UsuarioSkill usuarioSkill = usuarioSkillService.atualizarNivelSkill(usuarioId, request.getSkillId(), request.getNivel());
			return ResponseEntity.ok(usuarioSkill);
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
	
	@GetMapping("/listar/{usuarioId}")
	public ResponseEntity<List<UsuarioSkill>> listarSkillsDoUsuario(@PathVariable Long usuarioId){
		List<UsuarioSkill> skills = usuarioSkillService.listarSkillsDoUsuario(usuarioId);
		return ResponseEntity.ok(skills);
	}
	
	
}
