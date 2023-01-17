package com.example.shop.facade;

import com.example.shop.dtos.ProductDto;
import com.example.shop.models.Product;

import java.util.List;

public interface ProductFacade {

    Product findByName(String name);

    boolean createProduct(ProductDto product);

    boolean deleteById(Long id);

    List<ProductDto> getAll();

    List<Product> allProducts();

    List<Product> productgtList(Long idMin);

}
