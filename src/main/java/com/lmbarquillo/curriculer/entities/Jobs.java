package com.lmbarquillo.curriculer.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Jobs {
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
    private Sectors sector;
    @ManyToOne
    @JoinColumn(nullable = false)
    private Users user;

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

    public Sectors getSector() {
        return sector;
    }

    public void setSector(Sectors sector) {
        this.sector = sector;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }
}
