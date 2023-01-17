package com.example.shop.service;

import com.example.shop.dtos.ShopDto;
import com.example.shop.models.Shop;

import java.util.List;

public interface ShopService {


    List<ShopDto> getAll();

    Long createShop(Shop shop);

    void AddProduct(String name, List<Long> productID);

    void deleteById(Long id);

}
