package com.bogdan.kurs.controller;

import com.bogdan.kurs.entity.User;
import com.bogdan.kurs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class RegistrationController {

    @Autowired
    private UserService userService;

    @GetMapping("/user/registration")
    public String registration(Model model) {
        model.addAttribute("userForm", new User());

        return "auth/registration";
    }

    @PostMapping("/user/registration")
    public String addUser(
            @RequestParam(value = "username") String username,
            @RequestParam(value = "password") String password,
            @RequestParam(value = "passwordConfirm") String passwordConfirm,
            Model model) {

        // - проверить пароль
        //if (password != passwordConfirm) return "/auth/registration";

        User u = new User();
        u.setPassword(password);
        u.setUsername(username);
        if (!userService.saveUser( u)){
            return "auth/registration";
        }

        return "redirect:/";
    }
}