package com.lmbarquillo.curriculer.services.implementation;

import com.lmbarquillo.curriculer.entities.OtherSkill;
import com.lmbarquillo.curriculer.entities.User;
import com.lmbarquillo.curriculer.exceptions.generic.NotFoundException;
import com.lmbarquillo.curriculer.models.DigitalSkillModel;
import com.lmbarquillo.curriculer.models.SkillModel;
import com.lmbarquillo.curriculer.repositories.DigitalSkillRepository;
import com.lmbarquillo.curriculer.repositories.OtherSkillRepository;
import com.lmbarquillo.curriculer.services.SkillService;
import com.lmbarquillo.curriculer.utilities.Values;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class SkillServiceImpl implements SkillService {
    private DigitalSkillRepository digitalSkillRepository;
    private OtherSkillRepository otherSkillRepository;

    public SkillServiceImpl(DigitalSkillRepository digitalSkillRepository,
                            OtherSkillRepository otherSkillRepository) {
        this.digitalSkillRepository = digitalSkillRepository;
        this.otherSkillRepository = otherSkillRepository;
    }

    @Override
    public DigitalSkillModel getDigitalSkills(User user) {
        return digitalSkillRepository.findByUser_User(user).map(DigitalSkillModel::from).orElse(null);
    }

    @Override
    public List<SkillModel> getOtherSkills(User user) {
        return otherSkillRepository.findAllByUser(user).stream().map(SkillModel::from).collect(Collectors.toList());
    }

    @Override
    public SkillModel insertOtherSkill(User user, SkillModel model) {
        OtherSkill skill = new OtherSkill();
        skill.setUser(user);
        skill.setSkill(model.getSkill());

        return SkillModel.from(otherSkillRepository.save(skill));
    }

    @Override
    public SkillModel updateOtherSkill(User user, SkillModel model) throws NotFoundException {
        OtherSkill skill = otherSkillRepository.findById(model.getId()).orElseThrow(() -> new NotFoundException(Values.Errors.SKILL_NOT_FOUND));
        skill.setSkill(model.getSkill());
        return SkillModel.from(otherSkillRepository.save(skill));
    }

    @Override
    public Long deleteOtherSkill(User user, Long id) throws NotFoundException {
        OtherSkill skill = otherSkillRepository.findByUserAndId(user, id).orElseThrow(() -> new NotFoundException(Values.Errors.SKILL_NOT_FOUND));
        otherSkillRepository.delete(skill);
        return id;
    }
}
