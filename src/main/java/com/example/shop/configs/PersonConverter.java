package com.example.shop.configs;

import com.example.shop.dtos.PersonDto;
import com.example.shop.models.Person;

public final class PersonConverter {

    public static PersonDto getPersonDto(Person person) {
        PersonDto personDto = new PersonDto();
        personDto.setUsername(person.getUsername());
        personDto.setPassword(person.getPassword());
        personDto.setPasswordConfirm(person.getPasswordConfirm());
        return personDto;
    }

    public static Person getPerson(PersonDto personDto) {
        Person person = new Person();
        person.setUsername(personDto.getUsername());
        person.setPassword(personDto.getPassword());
        person.setPasswordConfirm(personDto.getPasswordConfirm());

        return person;
    }
}
