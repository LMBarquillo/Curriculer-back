package com.lmbarquillo.curriculer.entities;

import javax.persistence.*;

@Entity
public class DesiredJobs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    @Column(length = 50, nullable = false)
    private String job;
    @ManyToOne
    @JoinColumn(nullable = false)
    private Users user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }
}
