package com.example.shop.service;

import com.example.shop.models.Cart;
import com.example.shop.models.Person;
import com.example.shop.models.Role;
import com.example.shop.repository.PersonRepository;
import com.example.shop.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collections;
import java.util.List;

@Service
public class PersonServiceImpl implements UserDetailsService, PersonService {
    @PersistenceContext
    private EntityManager em;
    @Autowired
    PersonRepository personRepository;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    private CartService cartService;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Person user = personRepository.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }

        return user;
    }

    @Override
    public List<Person> allUsers() {
        return personRepository.findAll();
    }

    @Override
    public boolean deleteUser(Long userId) {
        if (personRepository.findById(userId).isPresent()) {
            personRepository.deleteById(userId);
            return true;
        }
        return false;
    }

    @Override
    public List<Person> persongtList(Long idMin) {
        return em.createQuery("SELECT u FROM Person u WHERE u.id > :paramId", Person.class)
                .setParameter("paramId", idMin).getResultList();
    }

    @Override
    public void addCart(Long productId, String name) {

        Person person = personRepository.findByUsername(name);

        Cart cart = person.getCart();
        if (cart == null) {
            Cart newCart = cartService.createCart(person, Collections.singletonList(productId));
            person.setCart(newCart);
            save(person);
        } else {
            cartService.addProduct(cart, Collections.singletonList(productId));
        }
    }

    @Override
    public boolean createPerson(Person person) {
        Person personFromDB = personRepository.findByUsername(person.getUsername());

        if (personFromDB != null) {

            return false;
        }

        person.setRoles(Collections.singleton(new Role(1L, "ROLE_USER")));
        person.setPassword(bCryptPasswordEncoder.encode(person.getPassword()));
        personRepository.save(person);
        return true;
    }

    @Override
    public void save(Person person) {
        personRepository.save(person);
    }


}
