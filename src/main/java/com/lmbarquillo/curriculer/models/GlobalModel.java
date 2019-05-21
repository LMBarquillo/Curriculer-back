package com.lmbarquillo.curriculer.models;

import java.util.Comparator;
import java.util.List;

public class GlobalModel {
    private UserModel user;
    private List<TrainingModel> trainings;
    private List<JobModel> jobs;
    private List<LanguageSkillModel> languages;
    private DigitalSkillModel digitalSkills;
    private List<SkillModel> otherSkills;

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }

    public List<TrainingModel> getTrainings() {
        return trainings;
    }

    public void setTrainings(List<TrainingModel> trainings) {
        this.trainings = trainings;
        this.trainings.sort(Comparator.comparing(TrainingModel::getPromotion).reversed());
    }

    public List<JobModel> getJobs() {
        return jobs;
    }

    public void setJobs(List<JobModel> jobs) {
        this.jobs = jobs;
        this.jobs.sort(Comparator.comparing(JobModel::getFrom).reversed());
    }

    public List<LanguageSkillModel> getLanguages() {
        return languages;
    }

    public void setLanguages(List<LanguageSkillModel> languages) {
        this.languages = languages;
    }

    public DigitalSkillModel getDigitalSkills() {
        return digitalSkills;
    }

    public void setDigitalSkills(DigitalSkillModel digitalSkills) {
        this.digitalSkills = digitalSkills;
    }

    public List<SkillModel> getOtherSkills() {
        return otherSkills;
    }

    public void setOtherSkills(List<SkillModel> otherSkills) {
        this.otherSkills = otherSkills;
    }
}
