package com.lmbarquillo.curriculer.services.implementation;

import com.lmbarquillo.curriculer.entities.User;
import com.lmbarquillo.curriculer.models.DigitalSkillModel;
import com.lmbarquillo.curriculer.models.SkillModel;
import com.lmbarquillo.curriculer.repositories.DigitalSkillRepository;
import com.lmbarquillo.curriculer.repositories.OtherSkillRepository;
import com.lmbarquillo.curriculer.services.SkillService;
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
        return DigitalSkillModel.from(digitalSkillRepository.findByUser_User(user));
    }

    @Override
    public List<SkillModel> getOtherSkills(User user) {
        return otherSkillRepository.findAllByUser(user).stream().map(SkillModel::from).collect(Collectors.toList());
    }
}
