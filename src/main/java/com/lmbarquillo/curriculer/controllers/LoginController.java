package com.lmbarquillo.curriculer.controllers;

import com.lmbarquillo.curriculer.entities.User;
import com.lmbarquillo.curriculer.exceptions.NotFoundException;
import com.lmbarquillo.curriculer.models.LoginModel;
import com.lmbarquillo.curriculer.models.UserBasicModel;
import com.lmbarquillo.curriculer.services.UserService;
import com.lmbarquillo.curriculer.utilities.Values;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class LoginController {
    private UserService userService;

    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(Values.EndPoints.LOGIN)
    public ResponseEntity<UserBasicModel> login(@RequestBody LoginModel model) throws NotFoundException {
        return ResponseEntity.ok(userService.login(model));
    }

    @GetMapping("/test-interceptor")
    public ResponseEntity otherEndPoint(@RequestAttribute(Values.Strings.ATTRIBUTE_USER) User user) {
        return ResponseEntity.ok().build();
    }
}
