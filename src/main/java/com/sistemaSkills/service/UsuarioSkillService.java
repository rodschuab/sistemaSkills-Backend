package com.sistemaSkills.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sistemaSkills.entity.Skill;
import com.sistemaSkills.entity.Usuario;
import com.sistemaSkills.entity.UsuarioSkill;
import com.sistemaSkills.repository.UsuarioSkillRepository;

import java.util.List;



@Service
public class UsuarioSkillService {
	
	@Autowired
	private UsuarioSkillRepository usuarioSkillRepository;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private SkillService skillService;
	
	public UsuarioSkill associarSkill(Long usuarioId, Long skillId, Integer nivel) {
		Usuario usuario = usuarioService.buscarPorId(usuarioId);
		Skill skill = skillService.buscarPorId(skillId);
		
		if(usuarioSkillRepository.findByUsuarioIdAndSkillId(usuarioId, skillId).isPresent()) {
			throw new RuntimeException("Skill ja associoada ao usuário");
		}
		
		UsuarioSkill usuarioSkill = new UsuarioSkill( usuario, skill, nivel);
		return usuarioSkillRepository.save(usuarioSkill);
	}
	
	public UsuarioSkill atualizarNivelSkill(Long usuarioId, Long skillId, Integer novoNivel) {
		UsuarioSkill usuarioSkill = usuarioSkillRepository
				.findByUsuarioIdAndSkillId(usuarioId, skillId)
				.orElseThrow(() -> new RuntimeException("Associacão não encontrada"));
		usuarioSkill.setNivel(novoNivel);
		return usuarioSkillRepository.save(usuarioSkill);
	}
	
	@Transactional
	public void excluirAssociacao(long usuarioId, Long skillId) {
		if(!usuarioSkillRepository.findByUsuarioIdAndSkillId(usuarioId, skillId).isPresent()) {
			throw new RuntimeException("Associação não encontrada");
		}
		
		usuarioSkillRepository.deleteByUsuarioIdAndSkillId(usuarioId, skillId);
		
		}
		public List<UsuarioSkill> listarSkillsDoUsuario(Long usuarioId){
			return usuarioSkillRepository.findByUsuarioId(usuarioId);
	}
}
