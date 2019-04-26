package com.lmbarquillo.curriculer.services;

import com.lmbarquillo.curriculer.entities.User;
import com.lmbarquillo.curriculer.models.DigitalSkillModel;


public interface DigitalSkillService {
    DigitalSkillModel getDigitalSkills(User user);
}
