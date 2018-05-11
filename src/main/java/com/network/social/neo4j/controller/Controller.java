package com.network.social.neo4j.controller;

import com.network.social.neo4j.pojos.Person;
import com.network.social.neo4j.repositories.PersonRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/")
public class Controller {
    private final PersonRepository personRepository;

    public Controller(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @GetMapping("/friends")
    public Collection<Person> getAllFriends() {
        return personRepository.getPeople();
    }

    @GetMapping("/people")
    public Collection<Person> getAllPersons() {
        return personRepository.getAll();
    }

    @PostMapping("/insert")
    public void insert(@RequestParam("name") String name) {
        personRepository.save(new Person(name));
    }

    @PostMapping("/friendship")
    public void createFriendship(@RequestParam("firstName") String firstName, @RequestParam("secondName") String secondName) {
        Person firstPerson = personRepository.findByName(firstName);
        Person secondPerson = personRepository.findByName(secondName);
        firstPerson.addFriendship(secondPerson);
        personRepository.save(firstPerson);
    }
}
