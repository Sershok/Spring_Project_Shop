package com.example.shop.service;

import com.example.shop.models.Person;

import java.util.List;

public interface PersonService {

    boolean createPerson(Person person);

    void save(Person person);

    List<Person> allPersons();

    void addCart(Long productId, String name);

    boolean deletePerson(Long userId);

    List<Person> persongtList(Long idMin);


}
