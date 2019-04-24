package com.lmbarquillo.curriculer.models;

import com.lmbarquillo.curriculer.entities.User;

import java.util.Date;

public class UserModel {
    private Long id;
    private String name;
    private String surname;
    private String address;
    private String city;
    private String email;
    private Date birthdate;
    private String nationality;
    private String picture;
    private String drivingLicense;

    public static UserModel from(User entity) {
        UserModel model = new UserModel();
        model.setId(entity.getId());
        model.setName(entity.getName());
        model.setSurname(entity.getSurname());
        model.setAddress(entity.getAddress());
        model.setCity(entity.getCity());
        model.setEmail(entity.getEmail());
        model.setBirthdate(entity.getBirthdate());
        model.setNationality(entity.getNationality());
        model.setPicture(entity.getPicture());
        model.setDrivingLicense(entity.getDrivingLicense());

        return model;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
}
