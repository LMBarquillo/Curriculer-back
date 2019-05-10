package com.lmbarquillo.curriculer.services.implementation;

import com.lmbarquillo.curriculer.entities.User;
import com.lmbarquillo.curriculer.models.LanguageGradeModel;
import com.lmbarquillo.curriculer.models.LanguageModel;
import com.lmbarquillo.curriculer.models.LanguageSkillModel;
import com.lmbarquillo.curriculer.repositories.LanguageRepository;
import com.lmbarquillo.curriculer.repositories.LanguageSkillGradeRepository;
import com.lmbarquillo.curriculer.repositories.LanguageSkillRepository;
import com.lmbarquillo.curriculer.services.LanguageService;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LanguageServiceImpl implements LanguageService {
    private LanguageSkillRepository languageSkillRepository;
    private LanguageRepository languageRepository;
    private LanguageSkillGradeRepository languageSkillGradeRepository;

    public LanguageServiceImpl(LanguageSkillRepository languageSkillRepository,
                               LanguageRepository languageRepository,
                               LanguageSkillGradeRepository languageSkillGradeRepository) {
        this.languageSkillRepository = languageSkillRepository;
        this.languageRepository = languageRepository;
        this.languageSkillGradeRepository = languageSkillGradeRepository;
    }

    @Override
    public List<LanguageSkillModel> getLanguageSkills(User user){
        return languageSkillRepository.findAllByPk_User(user)
                .orElse(Collections.emptyList())
                .stream()
                .map(LanguageSkillModel::from)
                .collect(Collectors.toList());
    }

    @Override
    public List<LanguageModel> getLanguages(User user) {
        return languageRepository.findAll()
                .stream()
                .map(LanguageModel::from)
                .collect(Collectors.toList());
    }

    @Override
    public List<LanguageGradeModel> getLanguageGrades(User user) {
        return languageSkillGradeRepository.findAll()
                .stream()
                .map(LanguageGradeModel::from)
                .collect(Collectors.toList());
    }
}
