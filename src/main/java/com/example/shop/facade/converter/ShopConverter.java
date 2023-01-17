package com.example.shop.facade.converter;


import com.example.shop.dtos.ShopDto;
import com.example.shop.models.Shop;

public final class ShopConverter {
    public static Shop getShop(ShopDto shopDto) {
        Shop shop = new Shop();
        shop.setName(shopDto.getName());
        return shop;
    }

    public static ShopDto getShopDto(Shop shop) {
        ShopDto shopDto = new ShopDto();
        shopDto.setName(shop.getName());
        shopDto.setProductName(shop.getProduct().listIterator().next().getName());
        shopDto.setProduct(shop.getProduct());
        return shopDto;
    }
}
