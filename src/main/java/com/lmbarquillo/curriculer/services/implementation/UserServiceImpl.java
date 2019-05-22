package com.lmbarquillo.curriculer.services.implementation;

import com.lmbarquillo.curriculer.entities.*;
import com.lmbarquillo.curriculer.exceptions.DuplicatedItemException;
import com.lmbarquillo.curriculer.exceptions.generic.NotFoundException;
import com.lmbarquillo.curriculer.models.LoginModel;
import com.lmbarquillo.curriculer.models.UserBasicModel;
import com.lmbarquillo.curriculer.models.UserModel;
import com.lmbarquillo.curriculer.models.UserRegisterModel;
import com.lmbarquillo.curriculer.repositories.DigitalSkillRepository;
import com.lmbarquillo.curriculer.repositories.LanguageRepository;
import com.lmbarquillo.curriculer.repositories.SkillGradeRepository;
import com.lmbarquillo.curriculer.repositories.UserRepository;
import com.lmbarquillo.curriculer.services.UserService;
import com.lmbarquillo.curriculer.utilities.Utilities;
import com.lmbarquillo.curriculer.utilities.Values;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private LanguageRepository languageRepository;
    private DigitalSkillRepository digitalSkillRepository;
    private SkillGradeRepository skillGradeRepository;

    public UserServiceImpl(UserRepository usersRepository,
                           LanguageRepository languageRepository,
                           DigitalSkillRepository digitalSkillRepository,
                           SkillGradeRepository skillGradeRepository) {
        this.userRepository = usersRepository;
        this.languageRepository = languageRepository;
        this.digitalSkillRepository = digitalSkillRepository;
        this.skillGradeRepository = skillGradeRepository;
    }

    @Override
    public UserBasicModel login(LoginModel model) throws NotFoundException {
        Optional<User> user = userRepository.findByUserAndPassword(model.getUser(), Utilities.MySQLPassword(model.getPass()));
        return user.map(UserBasicModel::from).orElseThrow(() -> new NotFoundException(Values.Errors.INVALID_USER));
    }

    @Override
    public User getUserDataByUser(String user) throws NotFoundException {
        return userRepository.findByUser(user).orElseThrow(() -> new NotFoundException(Values.Errors.USER_NOT_FOUND));
    }

    @Override
    public User checkUser(String user, String token) {
        return userRepository.checkUser(user, token);
    }

    @Override
    public UserBasicModel createUser(UserRegisterModel model) throws DuplicatedItemException, NotFoundException {
        if(userRepository.existsUserByEmail(model.getEmail())) {
            throw new DuplicatedItemException(Values.Errors.DUPLICATED_EMAIL);
        }
        if(userRepository.existsUserByUser(model.getUser())) {
            throw new DuplicatedItemException(Values.Errors.DUPLICATED_USER);
        }

        SkillGrade notSet = skillGradeRepository.findById(Values.Keys.SKILL_NOT_SET).orElseThrow(() -> new NotFoundException(Values.Errors.SKILL_NOT_FOUND));

        User user = User.from(model);
        Language lang = languageRepository.getOne(Values.Keys.LANGUAGE_SPANISH);
        user.setMotherLanguage(lang);
        userRepository.save(user);

        DigitalSkill digitalSkill = new DigitalSkill();
        digitalSkill.setUser(new UserPK(user));
        digitalSkill.setProcessing(notSet);
        digitalSkill.setContents(notSet);
        digitalSkill.setCommunication(notSet);
        digitalSkill.setSafety(notSet);
        digitalSkill.setSolving(notSet);
        digitalSkillRepository.save(digitalSkill);

        return UserBasicModel.from(user);
    }

    @Override
    public UserModel updateUserData(UserModel model) throws NotFoundException {
        User user = userRepository.findById(model.getId()).orElseThrow(() -> new NotFoundException(Values.Errors.USER_NOT_FOUND));
        user.updateFrom(model);
        return UserModel.from(userRepository.save(user));
    }

    @Override
    public UserModel updateImage(User user, String img) {
        user.setPicture(img);
        return UserModel.from(userRepository.save(user));
    }
}
