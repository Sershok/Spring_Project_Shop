package com.example.shop.facade;

import com.example.shop.dtos.PersonDto;
import com.example.shop.facade.converter.PersonConverter;
import com.example.shop.models.Person;
import com.example.shop.service.PersonServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class PersonFacadeImpl implements PersonFacade {
    private final PersonServiceImpl personService;

    public PersonFacadeImpl(PersonServiceImpl personService) {
        this.personService = personService;
    }


    @Override
    public boolean createPerson(PersonDto person) {
        Person newPerson = PersonConverter.getPerson(person);
        log.info("add person: " + newPerson.getUsername() + " : " + newPerson.getId() + " : " + newPerson.getPassword());
        return personService.createPerson(newPerson);
    }


    @Override
    public List<Person> allPersons() {
        return personService.allPersons();
    }

    @Override
    public void addCart(Long productId, String name) {
        log.info("add cart: " + name + " : " + productId);
        personService.addCart(productId, name);
    }

    @Override
    public boolean deletePerson(Long userId) {
        return personService.deletePerson(userId);
    }

    @Override
    public List<Person> persongtList(Long idMin) {
        return personService.persongtList(idMin);
    }
}
