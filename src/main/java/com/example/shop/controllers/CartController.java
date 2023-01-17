package com.example.shop.controllers;

import com.example.shop.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;


@Controller
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;


    @DeleteMapping("/delete_{id}")
    public void deleteById(@PathVariable Long id) {
        cartService.deleteById(id);
    }

    @GetMapping("/mcart")
    public String viewPersonCart(Model model, Principal principal) {
        model.addAttribute("getCart", cartService.getCart(principal.getName()));
        return "mcart";
    }

}
