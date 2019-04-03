package com.lmbarquillo.curriculer.services;

import com.lmbarquillo.curriculer.exceptions.NotFoundException;
import com.lmbarquillo.curriculer.models.LoginModel;
import com.lmbarquillo.curriculer.models.UserBasicModel;

public interface UserService {
    UserBasicModel login(LoginModel model) throws NotFoundException;
}
