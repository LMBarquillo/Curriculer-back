package com.lmbarquillo.curriculer.services;

import com.lmbarquillo.curriculer.entities.User;
import com.lmbarquillo.curriculer.models.LanguageGradeModel;
import com.lmbarquillo.curriculer.models.LanguageModel;
import com.lmbarquillo.curriculer.models.LanguageSkillModel;

import java.util.List;

public interface LanguageService {
    List<LanguageSkillModel> getLanguageSkills(User user);

    List<LanguageModel> getLanguages(User user);

    List<LanguageGradeModel> getLanguageGrades(User user);
}
