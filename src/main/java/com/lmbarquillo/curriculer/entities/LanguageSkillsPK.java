package com.lmbarquillo.curriculer.entities;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
public class LanguageSkillsPK implements Serializable {
    @ManyToOne
    @JoinColumn(nullable = false)
    private Users user;
    @ManyToOne
    @JoinColumn(nullable = false)
    private Languages language;

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public Languages getLanguage() {
        return language;
    }

    public void setLanguage(Languages language) {
        this.language = language;
    }
}
