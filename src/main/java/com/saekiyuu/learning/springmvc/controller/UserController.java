package com.saekiyuu.learning.springmvc.controller;

import com.saekiyuu.learning.springmvc.entity.User;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * UserController is based on Controller
 */
@Controller
public class UserController {
    
    /**
     * RequestMapping map a request to a method
     */
    @RequestMapping(value = "/register")
    public String Register(User user, Model model) {
        model.addAttribute("user", user);
        // View Name
        return "success";
    }
}
