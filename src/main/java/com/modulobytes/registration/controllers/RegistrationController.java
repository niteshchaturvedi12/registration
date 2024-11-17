package com.modulobytes.registration.controllers;

import com.modulobytes.registration.models.User;
import com.modulobytes.registration.dto.UserDTO;
import com.modulobytes.registration.exceptions.UserAlreadyExistsException;
import com.modulobytes.registration.services.IUserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(path = "/users")
public class RegistrationController {

    @Autowired
    IUserService userService;
    @GetMapping(path = "/registration")
    public String showRegistrationForm(WebRequest webRequest, Model model) {
        UserDTO userDTO = new UserDTO();
        model.addAttribute("user", userDTO);
        return "registration";
    }

    @PostMapping(path = "/register")
    public ModelAndView registerUserAccount(@ModelAttribute("user")  @Valid UserDTO userDTO,
                                            HttpServletRequest httpServletRequest, Errors errors) {
        User user;
        try {
            user = userService.registerNewUserAccount(userDTO);
        } catch (UserAlreadyExistsException exception) {
            return new ModelAndView("error").addObject("message", "an account for email "
                    +userDTO.getEmail()+" already exists");
        }
        return new ModelAndView("successRegister", "user", user);
    }
}
