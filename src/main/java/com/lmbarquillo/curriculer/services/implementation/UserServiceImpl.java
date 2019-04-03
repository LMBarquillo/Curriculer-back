package com.lmbarquillo.curriculer.services.implementation;

import com.lmbarquillo.curriculer.entities.User;
import com.lmbarquillo.curriculer.exceptions.NotFoundException;
import com.lmbarquillo.curriculer.models.LoginModel;
import com.lmbarquillo.curriculer.repositories.UserRepository;
import com.lmbarquillo.curriculer.services.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository usersRepository) {
        this.userRepository = usersRepository;
    }

    @Override
    public LoginModel login(LoginModel model) throws NotFoundException {
        User user = userRepository.login(model.getUser(), model.getPass());
        if(user == null) {
            throw new NotFoundException();
        }
        model.setPass(user.getPassword());  // Sustituimos el password por el encriptado.
        return model;
    }

}
