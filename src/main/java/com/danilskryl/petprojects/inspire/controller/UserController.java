package com.danilskryl.petprojects.inspire.controller;

import com.danilskryl.petprojects.inspire.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/users")
public class UserController {
    private final UserService service;

    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping
    public String showAll(Model model) {
        model.addAttribute(service.getAllUsers());
        return "all-users";
    }

    @GetMapping("/{id}")
    public String showUser(@PathVariable Long id) {
        return "one-user";
    }
}
