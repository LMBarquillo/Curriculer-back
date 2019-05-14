package com.lmbarquillo.curriculer.services.implementation;

import com.lmbarquillo.curriculer.entities.*;
import com.lmbarquillo.curriculer.exceptions.DuplicatedItemException;
import com.lmbarquillo.curriculer.exceptions.generic.NotFoundException;
import com.lmbarquillo.curriculer.models.LanguageGradeModel;
import com.lmbarquillo.curriculer.models.LanguageModel;
import com.lmbarquillo.curriculer.models.LanguageSkillModel;
import com.lmbarquillo.curriculer.repositories.LanguageRepository;
import com.lmbarquillo.curriculer.repositories.LanguageSkillGradeRepository;
import com.lmbarquillo.curriculer.repositories.LanguageSkillRepository;
import com.lmbarquillo.curriculer.services.LanguageService;
import com.lmbarquillo.curriculer.utilities.Values;
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
    public List<LanguageSkillModel> getLanguageSkills(User user) {
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

    @Override
    public LanguageSkillModel insertLanguage(User user, LanguageSkillModel languageSkill) throws NotFoundException, DuplicatedItemException {
        if(languageSkillRepository.findByPk_Language_IdAndPk_User(languageSkill.getLanguage().getId(), user).isPresent()) {
            throw new DuplicatedItemException(Values.Errors.DUPLICATED_LANGUAGE);
        }

        Language language = languageRepository.findById(languageSkill.getLanguage().getId()).orElseThrow(() -> new NotFoundException(Values.Errors.LANGUAGE_NOT_FOUND));

        LanguageSkill skill = new LanguageSkill();
        skill.setPk(new LanguageSkillPK(user, language));
        skill.setListening(languageSkillGradeRepository.findById(languageSkill.getListening().getId()).orElseThrow(() -> new NotFoundException(Values.Errors.GRADE_NOT_FOUND)));
        skill.setReading(languageSkillGradeRepository.findById(languageSkill.getReading().getId()).orElseThrow(() -> new NotFoundException(Values.Errors.GRADE_NOT_FOUND)));
        skill.setInteraction(languageSkillGradeRepository.findById(languageSkill.getInteraction().getId()).orElseThrow(() -> new NotFoundException(Values.Errors.GRADE_NOT_FOUND)));
        skill.setProduction(languageSkillGradeRepository.findById(languageSkill.getProduction().getId()).orElseThrow(() -> new NotFoundException(Values.Errors.GRADE_NOT_FOUND)));
        skill.setWriting(languageSkillGradeRepository.findById(languageSkill.getWriting().getId()).orElseThrow(() -> new NotFoundException(Values.Errors.GRADE_NOT_FOUND)));

        return LanguageSkillModel.from(languageSkillRepository.save(skill));
    }

    @Override
    public LanguageSkillModel updateLanguage(User user, LanguageSkillModel languageSkill) throws NotFoundException, DuplicatedItemException {
        LanguageSkill skill = languageSkillRepository.findByPk_Language_IdAndPk_User(languageSkill.getId(), user).orElseThrow(() -> new NotFoundException(Values.Errors.LANGUAGE_SKILL_NOT_FOUND));

        if (!languageSkill.getLanguage().getId().equals(skill.getPk().getLanguage().getId())) {
            if(languageSkillRepository.findByPk_Language_IdAndPk_User(languageSkill.getLanguage().getId(), user).isPresent()) {
                throw new DuplicatedItemException(Values.Errors.DUPLICATED_LANGUAGE);
            }
            Language language = languageRepository.findById(languageSkill.getId()).orElseThrow(() -> new NotFoundException(Values.Errors.LANGUAGE_NOT_FOUND));
            skill.setPk(new LanguageSkillPK(user, language));
        }
        if (!languageSkill.getListening().getId().equals(skill.getListening().getId())) {
            LanguageSkillGrade grade = languageSkillGradeRepository.findById(languageSkill.getListening().getId()).orElseThrow(() -> new NotFoundException(Values.Errors.GRADE_NOT_FOUND));
            skill.setListening(grade);
        }
        if (!languageSkill.getReading().getId().equals(skill.getReading().getId())) {
            LanguageSkillGrade grade = languageSkillGradeRepository.findById(languageSkill.getReading().getId()).orElseThrow(() -> new NotFoundException(Values.Errors.GRADE_NOT_FOUND));
            skill.setReading(grade);
        }
        if (!languageSkill.getInteraction().getId().equals(skill.getInteraction().getId())) {
            LanguageSkillGrade grade = languageSkillGradeRepository.findById(languageSkill.getInteraction().getId()).orElseThrow(() -> new NotFoundException(Values.Errors.GRADE_NOT_FOUND));
            skill.setInteraction(grade);
        }
        if (!languageSkill.getProduction().getId().equals(skill.getProduction().getId())) {
            LanguageSkillGrade grade = languageSkillGradeRepository.findById(languageSkill.getProduction().getId()).orElseThrow(() -> new NotFoundException(Values.Errors.GRADE_NOT_FOUND));
            skill.setProduction(grade);
        }
        if (!languageSkill.getWriting().getId().equals(skill.getWriting().getId())) {
            LanguageSkillGrade grade = languageSkillGradeRepository.findById(languageSkill.getWriting().getId()).orElseThrow(() -> new NotFoundException(Values.Errors.GRADE_NOT_FOUND));
            skill.setWriting(grade);
        }

        return LanguageSkillModel.from(languageSkillRepository.save(skill));
    }

    @Override
    public Long deleteLanguage(User user, Long id) throws NotFoundException {
        LanguageSkill skill = languageSkillRepository.findByPk_Language_IdAndPk_User(id, user).orElseThrow(() -> new NotFoundException(Values.Errors.LANGUAGE_SKILL_NOT_FOUND));

        languageSkillRepository.delete(skill);

        return skill.getPk().getLanguage().getId();
    }
}
