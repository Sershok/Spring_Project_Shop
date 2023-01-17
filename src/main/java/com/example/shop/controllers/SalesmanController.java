package com.example.shop.controllers;

import com.example.shop.dtos.ProductDto;
import com.example.shop.dtos.ShopDto;
import com.example.shop.facade.ProductFacade;
import com.example.shop.facade.converter.ShopConverter;
import com.example.shop.models.Product;
import com.example.shop.service.ShopService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

@Slf4j
@Controller
@RequestMapping("/salesman")
public class SalesmanController {

    private final ShopService shopService;
    private final ProductFacade productFacade;

    public SalesmanController(ShopService shopService, ProductFacade productFacade) {
        this.shopService = shopService;
        this.productFacade = productFacade;
    }

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
        if (!productFacade.createProduct(product)) {
            model.addAttribute("productnameError", "Product exists");
            return "product";
        }

        return "productSuccess";
    }

    @GetMapping("/Aproduct")
    public String productList(Model model) {
        model.addAttribute("allProducts", productFacade.allProducts());
        return "Aproduct";
    }

    @PostMapping("/Aproduct")
    public String deleteProduct(@RequestParam(required = true, defaultValue = "") Long productId,
                                @RequestParam(required = true, defaultValue = "") String action) {
        if (action.equals("delete")) {
            log.info("delete product by ID: " + productId);
            productFacade.deleteById(productId);
        }
        return "redirect:/salesman/Aproduct";
    }

    @GetMapping("/Aproduct/gtProduct/{productId}")
    public String gtProduct(@PathVariable("productId") Long productId, Model model) {
        model.addAttribute("allProducts", productFacade.productGetList(productId));
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

        Product product = productFacade.findByName(shopDto.getProductName());
        shopService.AddProduct(shopDto.getName(), Collections.singletonList(product.getId()));
        return "shopSuccess";
    }

    @DeleteMapping("/delete_{id}")
    public void deleteById(@PathVariable Long id) {
        shopService.deleteById(id);
    }
}
