package com.lmbarquillo.curriculer.services;

import com.lmbarquillo.curriculer.exceptions.NotFoundException;
import com.lmbarquillo.curriculer.models.LoginModel;

public interface UserService {
    LoginModel login(LoginModel model) throws NotFoundException;
}
