package com.lmbarquillo.curriculer.entities;

import javax.persistence.*;

@Entity
public class Activities {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    @Column(length = 70, nullable = false)
    private String activity;
    @ManyToOne
    @JoinColumn(nullable = false)
    private Jobs job;

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

    public Jobs getJob() {
        return job;
    }

    public void setJob(Jobs job) {
        this.job = job;
    }
}
