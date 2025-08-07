package com.sistemaSkills.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistemaSkills.entity.Skill;
import com.sistemaSkills.repository.SkillRepository;

import java.util.List;

@Service
public class SkillService {
	
	@Autowired
	private SkillRepository skillRepository;
	
	public Skill criarSkill(String nome, String descricao) {
		if(skillRepository.existsByNome(nome)) {
			throw new RuntimeException("Skill já existe");
		}
		
		Skill skill = new Skill(nome,descricao);
		return skillRepository.save(skill);
	}
	
	public List<Skill> listarTodasSkills(){
		return skillRepository.findAll();
	}
	
	public Skill buscarPorId(Long id) {
		return skillRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Skill não encontrada"));
	}

	public void excluirSkill(Long id) {
		if (!skillRepository.existsById(id)) {
			throw new RuntimeException("Skill não encontrada");
		}
		
		skillRepository.deleteById(id);
	}
}
