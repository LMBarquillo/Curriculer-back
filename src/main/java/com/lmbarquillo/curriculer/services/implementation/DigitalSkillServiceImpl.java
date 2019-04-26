package com.lmbarquillo.curriculer.services.implementation;

import com.lmbarquillo.curriculer.entities.User;
import com.lmbarquillo.curriculer.models.DigitalSkillModel;
import com.lmbarquillo.curriculer.repositories.DigitalSkillRepository;
import com.lmbarquillo.curriculer.services.DigitalSkillService;
import org.springframework.stereotype.Service;


@Service
public class DigitalSkillServiceImpl implements DigitalSkillService {
    private DigitalSkillRepository digitalSkillRepository;

    public DigitalSkillServiceImpl(DigitalSkillRepository digitalSkillRepository) {
        this.digitalSkillRepository = digitalSkillRepository;
    }

    @Override
    public DigitalSkillModel getDigitalSkills(User user) {
        return DigitalSkillModel.from(digitalSkillRepository.findByUser_User(user));
    }
}
