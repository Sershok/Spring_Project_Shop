package com.example.shop.configs;


import com.example.shop.dtos.ShopDto;
import com.example.shop.models.Shop;

public final class ShopConverter {
    public static Shop getShop(ShopDto shopDto) {

        Shop shop = new Shop();
        shop.setName(shopDto.getName());
        return shop;
    }
}
