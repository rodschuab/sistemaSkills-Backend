package com.sistemaSkills.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistemaSkills.entity.UsuarioSkill;

import java.util.List;
import java.util.Optional;

public interface UsuarioSkillRepository extends JpaRepository<UsuarioSkill, Long>{
	List<UsuarioSkill> findByUsuarioId(Long usuarioId);
	Optional<UsuarioSkill> findByUsuarioIdAndSkillId(Long usuarioId, Long skillId);
	void deleteByUsuarioIdAndSkillId(Long usuarioId, Long skillId);

}
