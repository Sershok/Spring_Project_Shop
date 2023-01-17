package com.example.shop.controllers;

import com.example.shop.configs.PersonConverter;
import com.example.shop.dtos.PersonDto;
import com.example.shop.service.PersonServiceImpl;
import com.example.shop.service.ProductServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;

@Slf4j
@Controller
public class PersonController {

    private final PersonServiceImpl personService;

    private final ProductServiceImpl productService;

    public PersonController(PersonServiceImpl personService, ProductServiceImpl productService) {
        this.personService = personService;
        this.productService = productService;
    }


    @GetMapping("/registration")
    public String registration(Model model) {
        log.info("Create Person");
        model.addAttribute("userForm", new PersonDto());

        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(@ModelAttribute("userForm") @Valid PersonDto userForm, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            log.error("Error");
            return "registration";
        }
        if (!userForm.getPassword().equals(userForm.getPasswordConfirm())) {
            log.error("Password not equals");
            model.addAttribute("passwordError", "Пароли не совпадают");
            return "registration";
        }
        if (!personService.createPerson(PersonConverter.getPerson(userForm))) {
            log.error("Person was created");
            model.addAttribute("usernameError", "Пользователь с таким именем уже существует");
            return "registration";
        }

        return "redirect:/";
    }

    @GetMapping("/cart")
    public String addProductFromCart(Model model) {
        model.addAttribute("allProducts", productService.allProducts());
        return "cart";
    }

    @PostMapping("/cart")
    public String createCart(@RequestParam(required = true, defaultValue = "") Long productId,
                             @RequestParam(required = true, defaultValue = "") String action,
                             Principal principal,
                             Model model) {

        if (action.equals("add")) {
            personService.addCart(productId, principal.getName());
            log.info("add product from cart: " + principal.getName());
        }
        return "redirect:/cart";
    }

    @GetMapping("cart/gtProduct/{productId}")
    public String gtProductFromCart(@PathVariable("productId") Long productId, Model model) {
        model.addAttribute("allProducts", productService.productgtList(productId));
        return "cart";
    }
}
