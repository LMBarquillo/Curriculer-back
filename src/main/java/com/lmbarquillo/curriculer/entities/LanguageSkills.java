package com.lmbarquillo.curriculer.entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class LanguageSkills {
    @EmbeddedId
    private LanguageSkillsPK pk;
    @ManyToOne
    @JoinColumn(nullable = false)
    private LanguageSkillGrades listening;
    @ManyToOne
    @JoinColumn(nullable = false)
    private LanguageSkillGrades reading;
    @ManyToOne
    @JoinColumn(nullable = false)
    private LanguageSkillGrades interaction;
    @ManyToOne
    @JoinColumn(nullable = false)
    private LanguageSkillGrades production;
    @ManyToOne
    @JoinColumn(nullable = false)
    private LanguageSkillGrades writing;

    public LanguageSkillsPK getPk() {
        return pk;
    }

    public void setPk(LanguageSkillsPK pk) {
        this.pk = pk;
    }

    public LanguageSkillGrades getListening() {
        return listening;
    }

    public void setListening(LanguageSkillGrades listening) {
        this.listening = listening;
    }

    public LanguageSkillGrades getReading() {
        return reading;
    }

    public void setReading(LanguageSkillGrades reading) {
        this.reading = reading;
    }

    public LanguageSkillGrades getInteraction() {
        return interaction;
    }

    public void setInteraction(LanguageSkillGrades interaction) {
        this.interaction = interaction;
    }

    public LanguageSkillGrades getProduction() {
        return production;
    }

    public void setProduction(LanguageSkillGrades production) {
        this.production = production;
    }

    public LanguageSkillGrades getWriting() {
        return writing;
    }

    public void setWriting(LanguageSkillGrades writing) {
        this.writing = writing;
    }

    public Users getUser() {
        return pk.getUser();
    }

    public Languages getLanguage() {
        return pk.getLanguage();
    }
}
