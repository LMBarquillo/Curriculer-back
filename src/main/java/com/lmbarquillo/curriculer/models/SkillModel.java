package com.lmbarquillo.curriculer.models;

import com.lmbarquillo.curriculer.entities.OtherSkill;

public class SkillModel {
    private Long id;
    private String skill;

    public SkillModel() {
    }

    public SkillModel(Long id, String skill) {
        this.id = id;
        this.skill = skill;
    }

    public static SkillModel from(OtherSkill entity) {
        return new SkillModel(entity.getId(), entity.getSkill());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }
}
