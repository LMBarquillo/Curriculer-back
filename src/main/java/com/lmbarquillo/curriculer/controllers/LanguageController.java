package com.lmbarquillo.curriculer.controllers;

import com.lmbarquillo.curriculer.services.LanguageService;
import org.springframework.stereotype.Controller;

@Controller
public class LanguageController {
    private LanguageService languageService;

    public LanguageController(LanguageService languageService) {
        this.languageService = languageService;
    }


}
