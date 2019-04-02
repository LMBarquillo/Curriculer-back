package com.lmbarquillo.curriculer.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class DigitalSkills implements Serializable {
    @Id
    @OneToOne
    @JoinColumn(nullable = false)
    private Users user;
    @ManyToOne
    @JoinColumn(nullable = false)
    private SkillGrades processing;
    @ManyToOne
    @JoinColumn(nullable = false)
    private SkillGrades communication;
    @ManyToOne
    @JoinColumn(nullable = false)
    private SkillGrades contents;
    @ManyToOne
    @JoinColumn(nullable = false)
    private SkillGrades safety;
    @ManyToOne
    @JoinColumn(nullable = false)
    private SkillGrades solving;

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public SkillGrades getProcessing() {
        return processing;
    }

    public void setProcessing(SkillGrades processing) {
        this.processing = processing;
    }

    public SkillGrades getCommunication() {
        return communication;
    }

    public void setCommunication(SkillGrades communication) {
        this.communication = communication;
    }

    public SkillGrades getContents() {
        return contents;
    }

    public void setContents(SkillGrades contents) {
        this.contents = contents;
    }

    public SkillGrades getSafety() {
        return safety;
    }

    public void setSafety(SkillGrades safety) {
        this.safety = safety;
    }

    public SkillGrades getSolving() {
        return solving;
    }

    public void setSolving(SkillGrades solving) {
        this.solving = solving;
    }
}
