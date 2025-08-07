package com.sistemaSkills.dto;

public class AssociarSkillRequest {
	private Long skillId;
	private Integer nivel;
	
	public AssociarSkillRequest() {}

	public AssociarSkillRequest(Long skillId, Integer nivel) {
		super();
		this.skillId = skillId;
		this.nivel = nivel;
	}

	public Long getSkillId() {
		return skillId;
	}

	public void setSkillId(Long skillId) {
		this.skillId = skillId;
	}

	public Integer getNivel() {
		return nivel;
	}

	public void setNivel(Integer nivel) {
		this.nivel = nivel;
	}
	
	

}
