package com.example.shop.facade;

import com.example.shop.dtos.CartDto;
import com.example.shop.dtos.PersonDto;

import java.util.List;

public interface CartFacade {

    CartDto createCart(PersonDto person, List<Long> productId);

    List<CartDto> getAll();

    List<CartDto> getCart(String name);

    boolean deleteById(Long id);

    void addProduct(CartDto cart, List<Long> productId);
}
