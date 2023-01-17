package com.example.shop.facade;

import com.example.shop.dtos.ProductDto;
import com.example.shop.facade.converter.ProductConverter;
import com.example.shop.models.Product;
import com.example.shop.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductFacadeImpl implements ProductFacade {

    @Autowired
    private ProductServiceImpl productService;

    @Override
    public Product findByName(String name) {
        Product product = productService.findByName(name);
        return product;
    }

    @Override
    public boolean createProduct(ProductDto product) {
        Product newProduct = ProductConverter.getProduct(product);
        return productService.createProduct(newProduct);
    }

    @Override
    public boolean deleteById(Long id) {
        return productService.deleteById(id);
    }

    @Override
    public List<ProductDto> getAll() {
        return productService.getAll();
    }

    @Override
    public List<Product> allProducts() {
        return productService.allProducts();
    }

    @Override
    public List<Product> productgtList(Long idMin) {
        return productService.productgtList(idMin);
    }
}
