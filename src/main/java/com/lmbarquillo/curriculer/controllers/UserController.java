package com.lmbarquillo.curriculer.controllers;

import com.lmbarquillo.curriculer.entities.User;
import com.lmbarquillo.curriculer.exceptions.DuplicatedItemException;
import com.lmbarquillo.curriculer.exceptions.generic.NotFoundException;
import com.lmbarquillo.curriculer.models.UserBasicModel;
import com.lmbarquillo.curriculer.models.UserModel;
import com.lmbarquillo.curriculer.models.UserRegisterModel;
import com.lmbarquillo.curriculer.services.UserService;
import com.lmbarquillo.curriculer.utilities.Values;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;

@Controller
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(Values.EndPoints.USER)
    public ResponseEntity<UserBasicModel> userRegister(@RequestBody UserRegisterModel user) throws DuplicatedItemException, UnsupportedEncodingException {
        return ResponseEntity.ok(userService.createUser(user));
    }

    @GetMapping(Values.EndPoints.USER)
    public ResponseEntity<UserModel> getUserData(@RequestAttribute(Values.Strings.ATTRIBUTE_USER) User user) {
        return ResponseEntity.ok(UserModel.from(user));
    }

    @PutMapping(Values.EndPoints.USER)
    public ResponseEntity<UserModel> updateUserData(@RequestAttribute(Values.Strings.ATTRIBUTE_USER) User user,
                                                    @RequestBody UserModel model) throws NotFoundException {
        return ResponseEntity.ok(userService.updateUserData(model));
    }

    @PutMapping(Values.EndPoints.AVATAR)
    public ResponseEntity<UserModel> updateImage(@RequestAttribute(Values.Strings.ATTRIBUTE_USER) User user,
                                                 @RequestBody String img) {
        return ResponseEntity.ok(userService.updateImage(user, img));
    }
}
