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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sistemaSkills.dto.SkillRequest;
import com.sistemaSkills.dto.SkillResponse;
import com.sistemaSkills.entity.Skill;
import com.sistemaSkills.service.SkillService;



@RestController
@RequestMapping("/skills")
@CrossOrigin(origins ="*")
public class SkillController {
	
	@Autowired
	private SkillService skillService;
	
	@PostMapping("/cadastrar")
	public ResponseEntity<?> cadastrarSkill(@RequestBody SkillRequest skillRequest){
		try {
			Skill skill = skillService.criarSkill(
				skillRequest.getNome(),
				skillRequest.getDescricao()
			);
			return ResponseEntity.ok(skill);
		}catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	@GetMapping("/listar")
	public ResponseEntity<List<SkillResponse>> listarSkills(){
	    List<Skill> skills = skillService.listarTodasSkills();
	    List<SkillResponse> skillsDTO = skills.stream()
	        .map(s -> new SkillResponse(s.getId(), s.getNome(), s.getDescricao(), s.getDataCadastro()))
	        .collect(Collectors.toList());
	    return ResponseEntity.ok(skillsDTO);
	}
	
	
	@DeleteMapping("/excluir/{id}")
	public ResponseEntity<?> excluirSkill(@PathVariable Long id){
		try {
			skillService.excluirSkill(id);
			return ResponseEntity.ok("Skill excluída!");
		}catch (Exception e){
			return ResponseEntity.badRequest().body(e.getMessage());
		}
		
	}
	

}
