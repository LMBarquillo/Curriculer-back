package com.lmbarquillo.curriculer.services.implementation;

import com.lmbarquillo.curriculer.entities.User;
import com.lmbarquillo.curriculer.models.LanguageModel;
import com.lmbarquillo.curriculer.repositories.LanguageSkillRepository;
import com.lmbarquillo.curriculer.services.LanguageService;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LanguageServiceImpl implements LanguageService {
    private LanguageSkillRepository languageSkillRepository;

    public LanguageServiceImpl(LanguageSkillRepository languageSkillRepository) {
        this.languageSkillRepository = languageSkillRepository;
    }

    @Override
    public List<LanguageModel> getLanguages(User user){
        return languageSkillRepository.findAllByPk_User(user)
                .orElse(Collections.emptyList())
                .stream()
                .map(LanguageModel::from)
                .collect(Collectors.toList());
    }


}
