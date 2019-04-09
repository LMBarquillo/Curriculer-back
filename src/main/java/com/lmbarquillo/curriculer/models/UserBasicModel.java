package com.lmbarquillo.curriculer.models;

import com.lmbarquillo.curriculer.entities.User;
import com.lmbarquillo.curriculer.utilities.Utilities;

public class UserBasicModel {
    private String user;
    private String surname;
    private String token;
    private String name;
    private String picture;

    public static UserBasicModel from(User entity) {
        UserBasicModel model = new UserBasicModel();
        model.setUser(entity.getUser());
        // Hasheamos el password encriptado. Doble seguridad.
        model.setToken(Utilities.sha512(entity.getPassword()));
        model.setName(entity.getName());
        model.setSurname(entity.getSurname());
        model.setPicture(entity.getPicture());
        return model;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
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

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
}
