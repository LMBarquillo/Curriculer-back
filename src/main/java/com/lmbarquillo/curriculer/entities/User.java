package com.lmbarquillo.curriculer.entities;

import com.lmbarquillo.curriculer.models.UserRegisterModel;
import com.lmbarquillo.curriculer.utilities.Utilities;
import com.lmbarquillo.curriculer.utilities.Values;

import javax.persistence.*;
import java.util.Date;

@Entity
@Embeddable
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    @Column(length = 45, nullable = false)
    private String user;
    @Column(length = 45, nullable = false)
    private String password;
    @Column(length = 60, nullable = false)
    private String name;
    @Column(length = 100, nullable = false)
    private String surname;
    @Column(length = 150, nullable = false)
    private String address;
    @Column(length = 80, nullable = false)
    private String city;
    @Column(length = 60, nullable = false)
    private String email;
    @Column
    private Date birthdate;
    @Column(length = 45)
    private String nationality;
    @Column(columnDefinition = Values.Definitions.TEXT)
    private String picture;
    @Column(length = 15)
    private String drivingLicense;
    @ManyToOne
    @JoinColumn(nullable = false)
    private Language motherLanguage;

    public static User from(UserRegisterModel model) {
        User user = new User();
        user.setName(model.getName());
        user.setSurname(model.getSurname());
        user.setEmail(model.getEmail());
        user.setUser(model.getUser());
        user.setPassword(Utilities.MySQLPassword(model.getPassword()));
        user.setAddress("");

        return user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getDrivingLicense() {
        return drivingLicense;
    }

    public void setDrivingLicense(String drivingLicense) {
        this.drivingLicense = drivingLicense;
    }

    public Language getMotherLanguage() {
        return motherLanguage;
    }

    public void setMotherLanguage(Language motherLanguage) {
        this.motherLanguage = motherLanguage;
    }
}
