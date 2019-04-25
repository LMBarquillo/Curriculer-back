package com.lmbarquillo.curriculer.models;

import com.lmbarquillo.curriculer.entities.Training;

public class TrainingModel {
    private Long id;
    private Integer promotion;
    private String qualification;
    private String center;
    private String city;

    public static TrainingModel from(Training entity) {
        TrainingModel model = new TrainingModel();
        model.setId(entity.getId());
        model.setPromotion(entity.getPromotion());
        model.setQualification(entity.getQualification());
        model.setCenter(entity.getCenter());
        model.setCity(entity.getCity());

        return model;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getPromotion() {
        return promotion;
    }

    public void setPromotion(Integer promotion) {
        this.promotion = promotion;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getCenter() {
        return center;
    }

    public void setCenter(String center) {
        this.center = center;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
