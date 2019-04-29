package com.lmbarquillo.curriculer.services;

import com.lmbarquillo.curriculer.entities.User;
import com.lmbarquillo.curriculer.models.DigitalSkillModel;
import com.lmbarquillo.curriculer.models.SkillModel;

import java.util.List;


public interface SkillService {
    DigitalSkillModel getDigitalSkills(User user);

    List<SkillModel> getOtherSkills(User user);
}
