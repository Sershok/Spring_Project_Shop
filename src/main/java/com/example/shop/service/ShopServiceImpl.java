package com.example.shop.service;

import com.example.shop.dtos.ShopDto;
import com.example.shop.models.Product;
import com.example.shop.models.Shop;
import com.example.shop.repository.ProductRepository;
import com.example.shop.repository.ShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShopServiceImpl implements ShopService {

    @Autowired
    private ShopRepository shopRepository;
    @Autowired
    private ProductRepository productRepository;

    private List<Product> getProductRef(List<Long> productId) {
        return productId.stream().map(productRepository::getOne).collect(Collectors.toList());
    }

    private void addProduct(Shop shop, List<Long> productId) {
        List<Product> products = shop.getProduct();
        List<Product> newProducts = products == null ? new ArrayList<>() : new ArrayList<>(products);
        newProducts.addAll(getProductRef(productId));
        shop.setProduct(newProducts);


        shopRepository.save(shop);
    }


    @Override
    public List<ShopDto> getAll() {
        return shopRepository.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public Long createShop(Shop shop) {
        return shopRepository.save(shop).getId();
    }

    @Override
    public void AddProduct(String name, List<Long> productID) {
        Shop shop = shopRepository.findByName(name);

        addProduct(shop, productID);
    }

    @Override
    public void deleteById(Long id) {
        shopRepository.deleteById(id);
    }


    private ShopDto toDto(Shop shop) {

        return ShopDto.builder()
                .name(shop.getName())
                .product(shop.getProduct())
                .build();
    }

}
