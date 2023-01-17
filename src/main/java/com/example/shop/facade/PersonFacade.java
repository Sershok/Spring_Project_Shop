package com.example.shop.facade;

import com.example.shop.dtos.PersonDto;
import com.example.shop.models.Person;

import java.util.List;

public interface PersonFacade {

    boolean createPerson(PersonDto person);

    void save(PersonDto person);

    List<Person> allUsers();

    void addCart(Long productId, String name);

    boolean deleteUser(Long userId);

    List<Person> persongtList(Long idMin);
}
