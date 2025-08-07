package com.sistemaSkills.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistemaSkills.entity.Skill;

import java.util.Optional;

public interface SkillRepository extends JpaRepository <Skill, Long>{
	Optional<Skill> findByNome(String nome);
	boolean existsByNome(String nome);

}
