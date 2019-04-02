package com.lmbarquillo.curriculer.entities;

import javax.persistence.*;

@Entity
public class Trainings {
    @Id
    @GeneratedValue
    @Column
    private Long id;
    @Column(scale = 4, nullable = false)
    private Integer promotion;
    @Column(length = 100, nullable = false)
    private String qualification;
    @Column(length = 50, nullable = false)
    private String center;
    @Column(length = 100)
    private String city;
    @ManyToOne
    @JoinColumn(nullable = false)
    private Users user;
}
