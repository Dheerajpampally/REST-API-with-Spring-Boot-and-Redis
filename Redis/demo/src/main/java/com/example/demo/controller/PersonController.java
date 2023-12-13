package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Person;
import com.example.demo.service.PersonService;

@RestController
@RequestMapping("/api/persons")
public class PersonController {
    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    public Person savePerson(@RequestBody Person person) {
        return personService.savePerson(person);
    }

    @GetMapping("/{id}")
    public Person getPerson(@PathVariable String id) {
        return personService.getPerson(id).orElse(null);
    }

    @GetMapping("/hash")
    public Iterable<Person> getAllPersonsFromHash() {
        return personService.getAllPersonsFromHashMap();
    }

    @GetMapping("/list")
    public Iterable<Person> getAllPersonsFromList() {
        return personService.getAllPersonsFromList();
    }

    @DeleteMapping("/{id}")
    public void deletePerson(@PathVariable String id) {
        personService.deletePerson(id);
    }

    @PutMapping("/{id}")
    public Person updatePerson(@PathVariable String id, @RequestBody Person updatedPerson) {
        return personService.updatePerson(id, updatedPerson);
    }
}

// // PersonController.java
// package com.example.demo.controller;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.DeleteMapping;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.PutMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;

// import com.example.demo.model.Person;
// import com.example.demo.service.PersonService;

// @RestController
// @RequestMapping("/api/persons/hash")
// public class PersonController {
// private final PersonService personService;

// @Autowired
// public PersonController(PersonService personService) {
// this.personService = personService;
// }

// @PostMapping
// public Person savePerson(@RequestBody Person person) {
// return personService.savePerson(person);
// }

// @GetMapping("/{id}")
// public Person getPerson(@PathVariable String id) {
// return personService.getPerson(id).orElse(null);
// }

// @GetMapping
// public Iterable<Person> getAllPersons() {
// return personService.getAllPersonsFromHashMap();
// }

// @DeleteMapping("/{id}")
// public void deletePerson(@PathVariable String id) {
// personService.deletePerson(id);
// }

// @PutMapping("/{id}")
// public Person updatePerson(@PathVariable String id, @RequestBody Person
// updatedPerson) {
// return personService.updatePerson(id, updatedPerson);
// }

// // Additional endpoint to get all persons from in-memory HashMap
// @GetMapping("/hash")
// public Iterable<Person> getAllPersonsFromHash() {
// return personService.getAllPersonsFromHashMap();
// }
// }

// package com.example.demo.controller;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.DeleteMapping;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;

// import com.example.demo.model.Person;
// import com.example.demo.service.PersonService;

// @RestController
// @RequestMapping("/api/persons")
// public class PersonController {
// private final PersonService personService;

// @Autowired
// public PersonController(PersonService personService) {
// this.personService = personService;
// }

// @PostMapping
// public Person savePerson(@RequestBody Person person) {
// return personService.savePerson(person);
// }

// @GetMapping("/{id}")
// public Person getPerson(@PathVariable String id) {
// return personService.getPerson(id).orElse(null);
// }

// @GetMapping
// public Iterable<Person> getAllPersons() {
// return personService.getAllPersons();
// }

// @DeleteMapping("/{id}")
// public void deletePerson(@PathVariable String id) {
// personService.deletePerson(id);
// }
// }
