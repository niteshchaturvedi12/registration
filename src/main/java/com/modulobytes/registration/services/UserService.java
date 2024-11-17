package com.modulobytes.registration.services;

import com.modulobytes.registration.models.User;
import com.modulobytes.registration.dto.UserDTO;
import com.modulobytes.registration.exceptions.UserAlreadyExistsException;
import com.modulobytes.registration.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService{

    @Autowired
    UserRepository userRepository;
    @Override
    public User registerNewUserAccount(UserDTO userDTO) throws UserAlreadyExistsException{
        if (userRepository.findByEmail(userDTO.getEmail()).isPresent()) {
            throw new UserAlreadyExistsException("user is already registered");
        }
        return userRepository.save(new User(userDTO));
    }
}
