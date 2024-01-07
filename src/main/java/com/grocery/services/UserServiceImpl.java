package com.grocery.services;

import com.grocery.exceptions.UserNotFoundException;
import com.grocery.lib.User;
import com.grocery.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Perform login related authentication/authrization
 * @author Harrish Anarase
 * @since 2024
 * @version 1.0
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public boolean isValidLogin(String user, char[] password) {
        try {
            return userRepository.isValidLogin(user, password) == 1 ? true : false;
        } catch (Exception e) {
            throw new UserNotFoundException("User Not Found w.r.t. name");
        }
    }

    @Override
    public User getUserInstant(String user) {
        return userRepository.findByName(user);
    }
}

