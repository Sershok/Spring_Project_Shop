package com.example.shop.facade;

import com.example.shop.configs.PersonConverter;
import com.example.shop.dtos.PersonDto;
import com.example.shop.models.Person;
import com.example.shop.service.PersonServiceImpl;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PersonFacadeImpl implements PersonFacade {
    private final PersonServiceImpl personService;

    public PersonFacadeImpl(PersonServiceImpl personService) {
        this.personService = personService;
    }


    @Override
    public boolean createPerson(PersonDto person) {
        Person newPerson = PersonConverter.getPerson(person);
        personService.createPerson(newPerson);
        return true;
    }

    @Override
    public void save(PersonDto person) {

    }

    @Override
    public List<Person> allUsers() {
        return null;
    }

    @Override
    public void addCart(Long productId, String name) {

    }

    @Override
    public boolean deleteUser(Long userId) {
        return false;
    }

    @Override
    public List<Person> persongtList(Long idMin) {
        return null;
    }
}
