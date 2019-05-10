package com.lmbarquillo.curriculer.models;

import com.lmbarquillo.curriculer.entities.LanguageSkillGrade;

public class LanguageGradeModel {
    private Long id;
    private String grade;

    public LanguageGradeModel() {
    }

    public LanguageGradeModel(Long id, String grade) {
        this.id = id;
        this.grade = grade;
    }

    public static LanguageGradeModel from(LanguageSkillGrade entity) {
        return new LanguageGradeModel(entity.getId(), entity.getGrade());
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
