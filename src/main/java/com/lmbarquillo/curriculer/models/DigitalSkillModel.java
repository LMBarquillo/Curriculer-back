package com.lmbarquillo.curriculer.models;

import com.lmbarquillo.curriculer.entities.DigitalSkill;

public class DigitalSkillModel {
    private SkillGradeModel processing;
    private SkillGradeModel communication;
    private SkillGradeModel contents;
    private SkillGradeModel safety;
    private SkillGradeModel solving;

    public static DigitalSkillModel from(DigitalSkill entity) {
        DigitalSkillModel model = new DigitalSkillModel();
        model.setProcessing(SkillGradeModel.from(entity.getProcessing()));
        model.setCommunication(SkillGradeModel.from(entity.getCommunication()));
        model.setContents(SkillGradeModel.from(entity.getContents()));
        model.setSafety(SkillGradeModel.from(entity.getSafety()));
        model.setSolving(SkillGradeModel.from(entity.getSolving()));
        return model;
    }

    public SkillGradeModel getProcessing() {
        return processing;
    }

    public void setProcessing(SkillGradeModel processing) {
        this.processing = processing;
    }

    public SkillGradeModel getCommunication() {
        return communication;
    }

    public void setCommunication(SkillGradeModel communication) {
        this.communication = communication;
    }

    public SkillGradeModel getContents() {
        return contents;
    }

    public void setContents(SkillGradeModel contents) {
        this.contents = contents;
    }

    public SkillGradeModel getSafety() {
        return safety;
    }

    public void setSafety(SkillGradeModel safety) {
        this.safety = safety;
    }

    public SkillGradeModel getSolving() {
        return solving;
    }

    public void setSolving(SkillGradeModel solving) {
        this.solving = solving;
    }
}
