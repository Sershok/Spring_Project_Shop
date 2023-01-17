package com.example.shop.facade;

import com.example.shop.dtos.CartDto;
import com.example.shop.dtos.PersonDto;

import java.util.List;

public class CartFacadeImpl implements CartFacade {
    @Override
    public CartDto createCart(PersonDto person, List<Long> productId) {
        return null;
    }

    @Override
    public List<CartDto> getAll() {
        return null;
    }

    @Override
    public List<CartDto> getCart(String name) {
        return null;
    }

    @Override
    public boolean deleteById(Long id) {
        return false;
    }

    @Override
    public void addProduct(CartDto cart, List<Long> productId) {

    }
}
