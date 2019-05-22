package com.lmbarquillo.curriculer.models;

import com.lmbarquillo.curriculer.entities.Job;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class JobModel {
    private Long id;
    private Date from;
    private Date to;
    private String employer;
    private String city;
    private SectorModel sector;
    private List<ActivityModel> activities;

    public static JobModel from(Job entity) {
        JobModel model = new JobModel();
        model.setId(entity.getId());
        model.setFrom(entity.getStartDate());
        model.setTo(entity.getEndDate());
        model.setEmployer(entity.getEmployer());
        model.setCity(entity.getCity());
        model.setSector(SectorModel.from(entity.getSector()));
        model.setActivities(entity.getActivities().stream().map(ActivityModel::from).collect(Collectors.toList()));

        return model;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFrom() {
        return from;
    }

    public void setFrom(Date from) {
        this.from = from;
    }

    public Date getTo() {
        return to;
    }

    public void setTo(Date to) {
        this.to = to;
    }

    public String getEmployer() {
        return employer;
    }

    public void setEmployer(String employer) {
        this.employer = employer;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public SectorModel getSector() {
        return sector;
    }

    public void setSector(SectorModel sector) {
        this.sector = sector;
    }

    public List<ActivityModel> getActivities() {
        return activities;
    }

    public void setActivities(List<ActivityModel> activities) {
        this.activities = activities;
    }
}
