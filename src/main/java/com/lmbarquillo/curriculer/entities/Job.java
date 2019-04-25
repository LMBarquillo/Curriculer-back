package com.lmbarquillo.curriculer.entities;

import com.lmbarquillo.curriculer.utilities.Values;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    @Column(nullable = false)
    private Date startDate;
    @Column
    private Date endDate;
    @Column(length = 50, nullable = false)
    private String employer;
    @Column(length = 100)
    private String city;
    @ManyToOne
    @JoinColumn(nullable = false)
    private Sector sector;
    @ManyToOne
    @JoinColumn(nullable = false)
    private User user;
    @OneToMany(mappedBy = Values.Keys.ACTIVITY_JOB)
    private List<Activity> activities;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
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

    public Sector getSector() {
        return sector;
    }

    public void setSector(Sector sector) {
        this.sector = sector;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Activity> getActivities() {
        return activities;
    }

    public void setActivities(List<Activity> activities) {
        this.activities = activities;
    }
}
