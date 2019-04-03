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
    private LanguageSkillGrade listening;
    @ManyToOne
    @JoinColumn(nullable = false)
    private LanguageSkillGrade reading;
    @ManyToOne
    @JoinColumn(nullable = false)
    private LanguageSkillGrade interaction;
    @ManyToOne
    @JoinColumn(nullable = false)
    private LanguageSkillGrade production;
    @ManyToOne
    @JoinColumn(nullable = false)
    private LanguageSkillGrade writing;

    public LanguageSkillsPK getPk() {
        return pk;
    }

    public void setPk(LanguageSkillsPK pk) {
        this.pk = pk;
    }

    public LanguageSkillGrade getListening() {
        return listening;
    }

    public void setListening(LanguageSkillGrade listening) {
        this.listening = listening;
    }

    public LanguageSkillGrade getReading() {
        return reading;
    }

    public void setReading(LanguageSkillGrade reading) {
        this.reading = reading;
    }

    public LanguageSkillGrade getInteraction() {
        return interaction;
    }

    public void setInteraction(LanguageSkillGrade interaction) {
        this.interaction = interaction;
    }

    public LanguageSkillGrade getProduction() {
        return production;
    }

    public void setProduction(LanguageSkillGrade production) {
        this.production = production;
    }

    public LanguageSkillGrade getWriting() {
        return writing;
    }

    public void setWriting(LanguageSkillGrade writing) {
        this.writing = writing;
    }

    public User getUser() {
        return pk.getUser();
    }

    public Language getLanguage() {
        return pk.getLanguage();
    }
}
