package com.example.shop.service;

import com.example.shop.dtos.CartDto;
import com.example.shop.models.Cart;
import com.example.shop.models.Person;

import java.util.List;

public interface CartService {

    Cart createCart(Person person, List<Long> productId);

    List<CartDto> getAll();

    List<CartDto> getCart(String name);

    boolean deleteById(Long id);

    void addProduct(Cart cart, List<Long> productId);
}
