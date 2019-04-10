package com.lmbarquillo.curriculer.controllers;

import com.lmbarquillo.curriculer.exceptions.DuplicatedItemException;
import com.lmbarquillo.curriculer.models.UserModel;
import com.lmbarquillo.curriculer.models.UserRegisterModel;
import com.lmbarquillo.curriculer.services.UserService;
import com.lmbarquillo.curriculer.utilities.Values;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.UnsupportedEncodingException;

@Controller
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {

        this.userService = userService;
    }

    @PostMapping(Values.EndPoints.USER)
    public ResponseEntity<UserModel> userRegister(@RequestBody UserRegisterModel user) throws DuplicatedItemException, UnsupportedEncodingException {
        return ResponseEntity.ok(userService.createUser(user));
    }

}
