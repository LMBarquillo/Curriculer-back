package com.lmbarquillo.curriculer.controllers;

import com.lmbarquillo.curriculer.entities.User;
import com.lmbarquillo.curriculer.models.LanguageModel;
import com.lmbarquillo.curriculer.services.LanguageService;
import com.lmbarquillo.curriculer.utilities.Values;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;

import java.util.List;

@Controller
public class LanguageController {
    private LanguageService languageService;

    public LanguageController(LanguageService languageService) {
        this.languageService = languageService;
    }

    @GetMapping(Values.EndPoints.LANGUAGES)
    public ResponseEntity<List<LanguageModel>> getLanguages(@RequestAttribute(Values.Strings.ATTRIBUTE_USER) User user) {
        return ResponseEntity.ok(languageService.getLanguages(user));
    }

}
