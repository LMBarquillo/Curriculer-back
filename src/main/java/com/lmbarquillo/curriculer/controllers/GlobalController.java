package com.lmbarquillo.curriculer.controllers;

import com.lmbarquillo.curriculer.entities.User;
import com.lmbarquillo.curriculer.exceptions.generic.NotFoundException;
import com.lmbarquillo.curriculer.models.GlobalModel;
import com.lmbarquillo.curriculer.models.UserModel;
import com.lmbarquillo.curriculer.services.*;
import com.lmbarquillo.curriculer.utilities.Values;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GlobalController {

    private UserService userService;
    private TrainingService trainingService;
    private JobService jobService;
    private LanguageService languageService;
    private SkillService skillService;

    public GlobalController(UserService userService,
                            TrainingService trainingService,
                            JobService jobService,
                            LanguageService languageService,
                            SkillService skillService) {

        this.userService = userService;
        this.trainingService = trainingService;
        this.jobService = jobService;
        this.languageService = languageService;
        this.skillService = skillService;
    }

    @GetMapping(Values.EndPoints.CURRICULUM)
    public ResponseEntity<GlobalModel> getCurriculum(@RequestParam String userName) throws NotFoundException {
        User user = userService.getUserDataByUser(userName);

        GlobalModel model = new GlobalModel();
        model.setUser(UserModel.from(user));
        model.setTrainings(trainingService.getTrainings(user));
        model.setJobs(jobService.getJobs(user));
        model.setLanguages(languageService.getLanguageSkills(user));
        model.setDigitalSkills(skillService.getDigitalSkills(user));
        model.setOtherSkills(skillService.getOtherSkills(user));

        return ResponseEntity.ok(model);
    }
}
