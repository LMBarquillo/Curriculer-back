package com.lmbarquillo.curriculer.models;

import com.lmbarquillo.curriculer.entities.LanguageSkill;

public class LanguageSkillModel {
    private Long id;
    private LanguageModel language;
    private SkillGradeModel listening;
    private SkillGradeModel reading;
    private SkillGradeModel interaction;
    private SkillGradeModel production;
    private SkillGradeModel writing;

    public static LanguageSkillModel from(LanguageSkill entity) {
        LanguageSkillModel model = new LanguageSkillModel();
        model.setId(entity.getLanguage().getId());
        model.setLanguage(LanguageModel.from(entity.getLanguage()));
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

    public LanguageModel getLanguage() {
        return language;
    }

    public void setLanguage(LanguageModel language) {
        this.language = language;
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
