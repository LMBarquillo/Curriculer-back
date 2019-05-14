package com.lmbarquillo.curriculer.controllers;

import com.lmbarquillo.curriculer.entities.User;
import com.lmbarquillo.curriculer.exceptions.DuplicatedItemException;
import com.lmbarquillo.curriculer.exceptions.generic.NotFoundException;
import com.lmbarquillo.curriculer.models.LanguageGradeModel;
import com.lmbarquillo.curriculer.models.LanguageModel;
import com.lmbarquillo.curriculer.models.LanguageSkillModel;
import com.lmbarquillo.curriculer.services.LanguageService;
import com.lmbarquillo.curriculer.utilities.Values;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class LanguageController {
    private LanguageService languageService;

    public LanguageController(LanguageService languageService) {
        this.languageService = languageService;
    }

    @GetMapping(Values.EndPoints.LANGUAGE_SKILLS)
    public ResponseEntity<List<LanguageSkillModel>> getLanguageSkills(@RequestAttribute(Values.Strings.ATTRIBUTE_USER) User user) {
        return ResponseEntity.ok(languageService.getLanguageSkills(user));
    }

    @GetMapping(Values.EndPoints.LANGUAGES)
    public ResponseEntity<List<LanguageModel>> getLanguages(@RequestAttribute(Values.Strings.ATTRIBUTE_USER) User user) {
        return ResponseEntity.ok(languageService.getLanguages(user));
    }

    @GetMapping(Values.EndPoints.LANGUAGE_GRADES)
    public ResponseEntity<List<LanguageGradeModel>> getLanguageGrades(@RequestAttribute(Values.Strings.ATTRIBUTE_USER) User user) {
        return ResponseEntity.ok(languageService.getLanguageGrades(user));
    }

    @PostMapping(Values.EndPoints.LANGUAGE_SKILLS)
    public ResponseEntity<LanguageSkillModel> insertLanguage(@RequestAttribute(Values.Strings.ATTRIBUTE_USER) User user,
                                                             @RequestBody LanguageSkillModel language) throws NotFoundException, DuplicatedItemException {
        return ResponseEntity.ok(languageService.insertLanguage(user, language));
    }

    @PutMapping(Values.EndPoints.LANGUAGE_SKILLS)
    public ResponseEntity<LanguageSkillModel> updateLanguage(@RequestAttribute(Values.Strings.ATTRIBUTE_USER) User user,
                                                             @RequestBody LanguageSkillModel language) throws NotFoundException, DuplicatedItemException {
        return ResponseEntity.ok(languageService.updateLanguage(user, language));
    }

    @DeleteMapping(Values.EndPoints.LANGUAGE_SKILLS + "/{id}")
    public ResponseEntity<Long> deleteLanguage(@RequestAttribute(Values.Strings.ATTRIBUTE_USER) User user,
                                                  @PathVariable Long id) throws NotFoundException {
        return ResponseEntity.ok(languageService.deleteLanguage(user, id));
    }
}
