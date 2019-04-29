package com.lmbarquillo.curriculer.controllers;

import com.lmbarquillo.curriculer.entities.User;
import com.lmbarquillo.curriculer.models.DigitalSkillModel;
import com.lmbarquillo.curriculer.models.SkillModel;
import com.lmbarquillo.curriculer.services.SkillService;
import com.lmbarquillo.curriculer.utilities.Values;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;

import java.util.List;

@Controller
public class SkillController {
    private SkillService skillService;

    public SkillController(SkillService skillService) {
        this.skillService = skillService;
    }

    @GetMapping(Values.EndPoints.DIGITAL_SKILLS)
    public ResponseEntity<DigitalSkillModel> getDigitalSkills(@RequestAttribute(Values.Strings.ATTRIBUTE_USER) User user) {
        return ResponseEntity.ok(skillService.getDigitalSkills(user));
    }

    @GetMapping(Values.EndPoints.OTHER_SKILLS)
    public ResponseEntity<List<SkillModel>> getOtherSkills(@RequestAttribute(Values.Strings.ATTRIBUTE_USER) User user) {
        return ResponseEntity.ok(skillService.getOtherSkills(user));
    }
}
