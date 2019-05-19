package com.lmbarquillo.curriculer.entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Entity
public class DigitalSkill implements Serializable {
    @EmbeddedId
    private UserPK user;
    @ManyToOne
    @JoinColumn(nullable = false)
    private SkillGrade processing;
    @ManyToOne
    @JoinColumn(nullable = false)
    private SkillGrade communication;
    @ManyToOne
    @JoinColumn(nullable = false)
    private SkillGrade contents;
    @ManyToOne
    @JoinColumn(nullable = false)
    private SkillGrade safety;
    @ManyToOne
    @JoinColumn(nullable = false)
    private SkillGrade solving;

    public DigitalSkill() {
    }

    public DigitalSkill(UserPK user) {
        this.user = user;
    }

    public UserPK getUser() {
        return user;
    }

    public void setUser(UserPK user) {
        this.user = user;
    }

    public SkillGrade getProcessing() {
        return processing;
    }

    public void setProcessing(SkillGrade processing) {
        this.processing = processing;
    }

    public SkillGrade getCommunication() {
        return communication;
    }

    public void setCommunication(SkillGrade communication) {
        this.communication = communication;
    }

    public SkillGrade getContents() {
        return contents;
    }

    public void setContents(SkillGrade contents) {
        this.contents = contents;
    }

    public SkillGrade getSafety() {
        return safety;
    }

    public void setSafety(SkillGrade safety) {
        this.safety = safety;
    }

    public SkillGrade getSolving() {
        return solving;
    }

    public void setSolving(SkillGrade solving) {
        this.solving = solving;
    }
}
