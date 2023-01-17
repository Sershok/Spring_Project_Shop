package com.example.shop.facade;

import com.example.shop.dtos.ProductDto;
import com.example.shop.facade.converter.ProductConverter;
import com.example.shop.models.Product;
import com.example.shop.service.ProductServiceImpl;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductFacadeImpl implements ProductFacade {

    private final ProductServiceImpl productService;

    public ProductFacadeImpl(ProductServiceImpl productService) {
        this.productService = productService;
    }

    @Override
    public Product findByName(String name) {
        return productService.findByName(name);
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
    public List<Product> productGetList(Long idMin) {
        return productService.productgtList(idMin);
    }
}
