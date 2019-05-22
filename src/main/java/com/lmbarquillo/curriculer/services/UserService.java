package com.lmbarquillo.curriculer.services;

import com.lmbarquillo.curriculer.entities.User;
import com.lmbarquillo.curriculer.exceptions.DuplicatedItemException;
import com.lmbarquillo.curriculer.exceptions.generic.NotFoundException;
import com.lmbarquillo.curriculer.models.LoginModel;
import com.lmbarquillo.curriculer.models.UserBasicModel;
import com.lmbarquillo.curriculer.models.UserModel;
import com.lmbarquillo.curriculer.models.UserRegisterModel;

import java.io.UnsupportedEncodingException;

public interface UserService {
    UserBasicModel login(LoginModel model) throws NotFoundException;

    User getUserDataByUser(String user) throws NotFoundException;

    User checkUser(String user, String token);

    UserBasicModel createUser(UserRegisterModel model) throws DuplicatedItemException, UnsupportedEncodingException, NotFoundException;

    UserModel updateUserData(UserModel model) throws NotFoundException;

    UserModel updateImage(User user, String img);
}
