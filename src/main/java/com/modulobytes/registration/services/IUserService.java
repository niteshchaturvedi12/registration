package com.modulobytes.registration.services;

import com.modulobytes.registration.models.User;
import com.modulobytes.registration.dto.UserDTO;

public interface IUserService {
    User registerNewUserAccount(UserDTO userDTO);
}
