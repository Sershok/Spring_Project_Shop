package com.example.shop.facade.converter;

import com.example.shop.dtos.ProductDto;
import com.example.shop.models.Product;

public final class ProductConverter {

    public static Product getProduct(ProductDto productDto) {
        Product product = new Product();
        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        return product;
    }

    public static ProductDto getProductDto(Product product) {
        ProductDto productDto = new ProductDto();
        productDto.setName(product.getName());
        productDto.setPrice(product.getPrice());
        return productDto;
    }
}
