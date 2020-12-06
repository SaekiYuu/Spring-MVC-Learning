package com.saekiyuu.learning.springmvc.controller;

import javax.validation.Valid;

import com.saekiyuu.learning.springmvc.entity.User;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * UserController is based on Controller
 */
@Controller
public class UserController {
    
    @RequestMapping(value = "/registerForm")
    public String registerForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @RequestMapping(value = "/register")
    public String register(@Valid @ModelAttribute("user") User user, Errors errors, Model model) {
        if (errors.hasErrors())
            return "register";
        model.addAttribute("user", user);
        // View Name
        return "success";
    }
}
