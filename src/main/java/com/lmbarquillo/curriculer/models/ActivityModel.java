package com.lmbarquillo.curriculer.models;

import com.lmbarquillo.curriculer.entities.Activity;

public class ActivityModel {
    private Long id;
    private String activity;

    public ActivityModel() {
    }

    public ActivityModel(Long id, String activy) {
        this.id = id;
        this.activity = activy;
    }

    public static ActivityModel from(Activity entity) {
        return new ActivityModel(entity.getId(), entity.getActivity());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }
}
