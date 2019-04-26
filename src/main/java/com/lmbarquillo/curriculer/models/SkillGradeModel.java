package com.lmbarquillo.curriculer.models;

import com.lmbarquillo.curriculer.entities.LanguageSkillGrade;

public class SkillGradeModel {
    private Long id;
    private String grade;

    public SkillGradeModel() {
    }

    public SkillGradeModel(Long id, String skill) {
        this.id = id;
        this.grade = skill;
    }

    public static SkillGradeModel from(LanguageSkillGrade entity) {
        return new SkillGradeModel(entity.getId(), entity.getGrade());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}
