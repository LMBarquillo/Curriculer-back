package com.lmbarquillo.curriculer.services.implementation;

import com.lmbarquillo.curriculer.entities.User;
import com.lmbarquillo.curriculer.exceptions.DuplicatedItemException;
import com.lmbarquillo.curriculer.exceptions.generic.NotFoundException;
import com.lmbarquillo.curriculer.models.LoginModel;
import com.lmbarquillo.curriculer.models.UserBasicModel;
import com.lmbarquillo.curriculer.models.UserModel;
import com.lmbarquillo.curriculer.models.UserRegisterModel;
import com.lmbarquillo.curriculer.repositories.UserRepository;
import com.lmbarquillo.curriculer.services.UserService;
import com.lmbarquillo.curriculer.utilities.Values;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository usersRepository) {
        this.userRepository = usersRepository;
    }

    @Override
    public UserBasicModel login(LoginModel model) throws NotFoundException {
        User user = userRepository.login(model.getUser(), model.getPass());
        if(user == null) {
            throw new NotFoundException(Values.Errors.INVALID_USER);
        }
        return UserBasicModel.from(user);
    }

    @Override
    public User checkUser(String user, String token) {
        return userRepository.checkUser(user, token);
    }

    @Override
    public UserModel createUser(UserRegisterModel model) throws DuplicatedItemException, UnsupportedEncodingException {
        if(userRepository.existsUserByEmail(model.getEmail())) {
            throw new DuplicatedItemException(Values.Errors.DUPLICATED_EMAIL);
        }
        if(userRepository.existsUserByUser(model.getUser())) {
            throw new DuplicatedItemException(Values.Errors.DUPLICATED_USER);
        }

        User user = User.from(model);
        userRepository.save(user);
        return UserModel.from(user);
    }

}
