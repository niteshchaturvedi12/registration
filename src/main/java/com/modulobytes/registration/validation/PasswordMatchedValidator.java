package com.modulobytes.registration.validation;

import com.modulobytes.registration.dto.UserDTO;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PasswordMatchedValidator implements ConstraintValidator<PasswordMatches, Object> {
    @Override
    public void initialize(PasswordMatches constraintAnnotation) {
    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        UserDTO userDTO = (UserDTO) o;
        return userDTO.getPassword().equals(userDTO.getMatchingPassword());
    }
}
