package com.lmbarquillo.curriculer.entities;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.io.Serializable;

@Embeddable
public class UserPK implements Serializable {
    @OneToOne
    @JoinColumn(nullable = false)
    private User user;

    public UserPK() {
    }

    public UserPK(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
