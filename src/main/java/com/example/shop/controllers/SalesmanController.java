package com.example.shop.controllers;

import com.example.shop.facade.converter.ProductConverter;
import com.example.shop.facade.converter.ShopConverter;
import com.example.shop.dtos.ProductDto;
import com.example.shop.dtos.ShopDto;
import com.example.shop.models.Product;
import com.example.shop.service.ProductServiceImpl;
import com.example.shop.service.ShopService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

@Slf4j
@Controller
@RequestMapping("/salesman")
public class SalesmanController {

    @Autowired
    private ShopService shopService;
    @Autowired
    private ProductServiceImpl productService;

    @GetMapping("/create")
    public String createProduct(Model model) {
        model.addAttribute("product", new ProductDto());

        return "product";
    }

    @PostMapping("/create")
    public String submitForm(@ModelAttribute("product") ProductDto product, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            return "product";
        }
        if (!productService.createProduct(ProductConverter.getProduct(product))) {
            model.addAttribute("productnameError", "Product exists");
            return "product";
        }

        return "productSuccess";
    }

    @GetMapping("/Aproduct")
    public String productList(Model model) {
        model.addAttribute("allProducts", productService.allProducts());
        return "Aproduct";
    }

    @PostMapping("/Aproduct")
    public String deleteProduct(@RequestParam(required = true, defaultValue = "") Long productId,
                                @RequestParam(required = true, defaultValue = "") String action,
                                Model model) {
        if (action.equals("delete")) {
            log.info("delete product by ID: " + productId);
            productService.deleteById(productId);
        }
        return "redirect:/salesman/Aproduct";
    }

    @GetMapping("/Aproduct/gtProduct/{productId}")
    public String gtProduct(@PathVariable("productId") Long productId, Model model) {
        model.addAttribute("allProducts", productService.productgtList(productId));
        return "Aproduct";
    }

    @GetMapping("/Shopcreate")
    public String createShop(Model model) {
        ShopDto shopDto = new ShopDto();

        model.addAttribute("shop", shopDto);

        return "shopCreate";
    }

    @PostMapping("/Shopcreate")
    public String submitShop(@ModelAttribute("shopDto") ShopDto shopDto) {

        shopService.createShop(ShopConverter.getShop(shopDto));

        return "shopAdd";
    }

    @GetMapping("/add_product")
    public String addProductsShop(Model model) {
        ShopDto shopDto = new ShopDto();
        model.addAttribute("shop", shopDto);
        return "shop";
    }

    @PostMapping("/add_product")
    public String submitCart(@ModelAttribute("shopDto") ShopDto shopDto) {

        Product product = productService.findByName(shopDto.getProductName());
        shopService.AddProduct(shopDto.getName(), Collections.singletonList(product.getId()));
        return "shopSuccess";
    }

    @DeleteMapping("/delete_{id}")
    public void deleteById(@PathVariable Long id) {
        shopService.deleteById(id);
    }
}
