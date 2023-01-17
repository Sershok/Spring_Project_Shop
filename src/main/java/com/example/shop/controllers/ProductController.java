package com.example.shop.controllers;

import com.example.shop.dtos.ProductDto;
import com.example.shop.facade.ProductFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ProductController {

    @Autowired
    private ProductFacade productFacade;

    @GetMapping("/product/productList")
    public String viewProductList(Model model) {

        List<ProductDto> productDto = productFacade.getAll();

        model.addAttribute("product", productDto);

        return "productList";
    }

}
