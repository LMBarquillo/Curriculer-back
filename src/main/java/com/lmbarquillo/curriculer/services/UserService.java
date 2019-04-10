package com.lmbarquillo.curriculer.services;

import com.lmbarquillo.curriculer.entities.User;
import com.lmbarquillo.curriculer.exceptions.NotFoundException;
import com.lmbarquillo.curriculer.models.LoginModel;
import com.lmbarquillo.curriculer.models.UserBasicModel;

public interface UserService {
    UserBasicModel login(LoginModel model) throws NotFoundException;

    User checkUser(String user, String token);
}
