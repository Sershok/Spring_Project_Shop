package com.example.shop.controllers;

import com.example.shop.service.PersonServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Slf4j
@Controller
public class AdminController {
    private final PersonServiceImpl personService;

    public AdminController(PersonServiceImpl personService) {
        this.personService = personService;
    }

    @GetMapping("/admin")
    public String userList(Model model) {

        model.addAttribute("allUsers", personService.allUsers());
        return "admin";
    }

    @PostMapping("/admin")
    public String deleteUser(@RequestParam(required = true, defaultValue = "") Long userId,
                             @RequestParam(required = true, defaultValue = "") String action,
                             Model model) {
        if (action.equals("delete")) {
            log.info("delete person by ID: " + userId);
            personService.deleteUser(userId);
        }
        return "redirect:/admin";

    }

    @GetMapping("/admin/gt/{userId}")
    public String gtUser(@PathVariable("userId") Long userId, Model model) {
        model.addAttribute("allUsers", personService.persongtList(userId));
        return "admin";
    }
}
