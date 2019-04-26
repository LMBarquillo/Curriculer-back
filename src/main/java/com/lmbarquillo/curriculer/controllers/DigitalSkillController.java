package com.lmbarquillo.curriculer.controllers;

import com.lmbarquillo.curriculer.entities.User;
import com.lmbarquillo.curriculer.models.DigitalSkillModel;
import com.lmbarquillo.curriculer.services.DigitalSkillService;
import com.lmbarquillo.curriculer.utilities.Values;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;

@Controller
public class DigitalSkillController {
    private DigitalSkillService digitalSkillService;

    public DigitalSkillController(DigitalSkillService digitalSkillService) {
        this.digitalSkillService = digitalSkillService;
    }

    @GetMapping(Values.EndPoints.DIGITAL_SKILLS)
    public DigitalSkillModel getDigitalSkills(@RequestAttribute(Values.Strings.ATTRIBUTE_USER) User user) {
        return digitalSkillService.getDigitalSkills(user);
    }

}
