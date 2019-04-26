package com.lmbarquillo.curriculer.models;

import com.lmbarquillo.curriculer.entities.LanguageSkill;

public class LanguageModel {
    private Long id;
    private String language;
    private String code;
    private SkillGradeModel listening;
    private SkillGradeModel reading;
    private SkillGradeModel interaction;
    private SkillGradeModel production;
    private SkillGradeModel writing;

    public static LanguageModel from(LanguageSkill entity) {
        LanguageModel model = new LanguageModel();
        model.setId(entity.getLanguage().getId());
        model.setLanguage(entity.getLanguage().getLanguage());
        model.setCode(entity.getLanguage().getCode());
        model.setListening(SkillGradeModel.from(entity.getListening()));
        model.setReading(SkillGradeModel.from(entity.getReading()));
        model.setInteraction(SkillGradeModel.from(entity.getInteraction()));
        model.setProduction(SkillGradeModel.from(entity.getProduction()));
        model.setWriting(SkillGradeModel.from(entity.getWriting()));

        return model;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public SkillGradeModel getListening() {
        return listening;
    }

    public void setListening(SkillGradeModel listening) {
        this.listening = listening;
    }

    public SkillGradeModel getReading() {
        return reading;
    }

    public void setReading(SkillGradeModel reading) {
        this.reading = reading;
    }

    public SkillGradeModel getInteraction() {
        return interaction;
    }

    public void setInteraction(SkillGradeModel interaction) {
        this.interaction = interaction;
    }

    public SkillGradeModel getProduction() {
        return production;
    }

    public void setProduction(SkillGradeModel production) {
        this.production = production;
    }

    public SkillGradeModel getWriting() {
        return writing;
    }

    public void setWriting(SkillGradeModel writing) {
        this.writing = writing;
    }
}
