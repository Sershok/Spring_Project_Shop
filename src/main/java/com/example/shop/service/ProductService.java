package com.example.shop.service;

import com.example.shop.dtos.ProductDto;
import com.example.shop.models.Product;

import java.util.List;

public interface ProductService {

    Product findByName(String name);

    boolean createProduct(Product product);

    boolean deleteById(Long id);

    List<ProductDto> getAll();

    List<Product> allProducts();

    List<Product> productgtList(Long idMin);

}
