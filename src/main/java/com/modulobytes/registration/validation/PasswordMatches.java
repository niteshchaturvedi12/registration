package com.modulobytes.registration.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PasswordMatchedValidator.class)
@Documented
public @interface PasswordMatches {
    String message() default "Password does not match";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
