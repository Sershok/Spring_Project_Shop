package com.example.shop.facade;

import com.example.shop.dtos.PersonDto;
import com.example.shop.models.Person;

import java.util.List;

public interface PersonFacade {

    boolean createPerson(PersonDto person);

    List<Person> allPersons();

    void addCart(Long productId, String name);

    boolean deletePerson(Long userId);

    List<Person> persongtList(Long idMin);
}
