package com.example.shop.controllers;

import com.example.shop.dtos.ShopDto;
import com.example.shop.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/shop")
public class ShopController {

    @Autowired
    private ShopService shopService;

    @GetMapping("/get")
    public String getProduct(HttpServletRequest request) {
        List<ShopDto> shopDto = shopService.getAll();
        request.setAttribute("shop", shopDto);

        return "shopList";
    }


}
