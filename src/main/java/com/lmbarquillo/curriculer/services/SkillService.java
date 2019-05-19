package com.lmbarquillo.curriculer.services;

import com.lmbarquillo.curriculer.entities.User;
import com.lmbarquillo.curriculer.exceptions.generic.NotFoundException;
import com.lmbarquillo.curriculer.models.DigitalSkillModel;
import com.lmbarquillo.curriculer.models.SkillGradeModel;
import com.lmbarquillo.curriculer.models.SkillModel;

import java.util.List;


public interface SkillService {
    List<SkillGradeModel> getSkillGrades(User user);

    DigitalSkillModel getDigitalSkills(User user);

    DigitalSkillModel updateDigitalSkills(User user, DigitalSkillModel model) throws NotFoundException;

    List<SkillModel> getOtherSkills(User user);

    SkillModel insertOtherSkill(User user, SkillModel model);

    SkillModel updateOtherSkill(User user, SkillModel model) throws NotFoundException;

    Long deleteOtherSkill(User user, Long id) throws NotFoundException;
}
