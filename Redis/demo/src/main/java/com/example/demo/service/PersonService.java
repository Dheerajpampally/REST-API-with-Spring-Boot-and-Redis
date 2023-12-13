package com.example.demo.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repo.PersonRepository;
import com.example.demo.model.Person;

@Service
public class PersonService {
    private final PersonRepository personRepository;
    private final Map<String, Person> personHashMap = new HashMap<>();
    private final List<Person> personList = new ArrayList<>();

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Person savePerson(Person person) {
        personRepository.save(person);
        saveToHashMap(person);
        saveToList(person);
        return person;
    }

    public void deletePerson(String id) {
        personRepository.deleteById(id);
        deleteFromHashMap(id);
        deleteFromList(id);
    }

    public Optional<Person> getPerson(String id) {
        Optional<Person> personFromHashMap = getFromHashMap(id);
        return personFromHashMap.isPresent() ? personFromHashMap : personRepository.findById(id);
    }

    public Iterable<Person> getAllPersonsFromHashMap() {
        return personHashMap.values();
    }

    public Iterable<Person> getAllPersonsFromList() {
        return personList;
    }

    public Person updatePerson(String id, Person updatedPerson) {
        return personRepository.findById(id)
                .map(person -> {
                    person.setName(updatedPerson.getName());
                    person.setAge(updatedPerson.getAge());
                    personRepository.save(person);
                    updateHashMapAndList(id, person);
                    return person;
                })
                .orElse(null);
    }

    private void saveToHashMap(Person person) {
        personHashMap.put(person.getId(), person);
    }

    private void deleteFromHashMap(String id) {
        personHashMap.remove(id);
    }

    private Optional<Person> getFromHashMap(String id) {
        return Optional.ofNullable(personHashMap.get(id));
    }

    private void saveToList(Person person) {
        personList.add(person);
    }

    private void deleteFromList(String id) {
        personList.removeIf(person -> person.getId().equals(id));
    }

    private void updateHashMapAndList(String id, Person updatedPerson) {
        personHashMap.put(id, updatedPerson);
        personList.replaceAll(person -> {
            if (person.getId().equals(id)) {
                return updatedPerson;
            }
            return person;
        });
    }
}

// package com.example.demo.service;

// import java.util.HashMap;
// import java.util.Map;
// import java.util.Optional;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;

// import com.example.demo.Repo.PersonRepository;
// import com.example.demo.model.Person;

// @Service
// public class PersonService {
// private final PersonRepository personRepository;
// private final Map<String, Person> personHashMap = new HashMap<>();

// @Autowired
// public PersonService(PersonRepository personRepository) {
// this.personRepository = personRepository;
// }

// public Person savePerson(Person person) {
// personRepository.save(person);
// saveToHashMap(person);
// return person;
// }

// public void deletePerson(String id) {
// personRepository.deleteById(id);
// deleteFromHashMap(id);
// }

// public Optional<Person> getPerson(String id) {
// Optional<Person> personFromHashMap = getFromHashMap(id);
// return personFromHashMap.isPresent() ? personFromHashMap :
// personRepository.findById(id);
// }

// public Iterable<Person> getAllPersonsFromHashMap() {
// return personHashMap.values();
// }

// public Person updatePerson(String id, Person updatedPerson) {
// if (personRepository.existsById(id)) {
// updatedPerson.setId(id);
// personRepository.save(updatedPerson);
// saveToHashMap(updatedPerson);
// return updatedPerson;
// }
// return null;
// }

// private void saveToHashMap(Person person) {
// personHashMap.put(person.getId(), person);
// }

// private void deleteFromHashMap(String id) {
// personHashMap.remove(id);
// }

// private Optional<Person> getFromHashMap(String id) {
// return Optional.ofNullable(personHashMap.get(id));
// }
// }

// package com.example.demo.service;

// import java.util.Map;
// import java.util.Optional;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;

// import com.example.demo.Repo.PersonRepository;
// import com.example.demo.model.Person;

// @Service
// public class PersonService {
// private final PersonRepository personRepository;
// private final Map<String, Person> personHashMap;

// @Autowired
// public PersonService(PersonRepository personRepository, Map<String, Person>
// personHashMap) {
// this.personRepository = personRepository;
// this.personHashMap = personHashMap;
// }

// public Person savePerson(Person person) {
// personRepository.save(person);
// saveToHashMap(person);
// return person;
// }

// public void updatePerson(String id, Person updatedPerson) {
// Person existingPerson = getPerson(id).orElse(null);
// if (existingPerson != null) {
// existingPerson.setName(updatedPerson.getName());
// existingPerson.setAge(updatedPerson.getAge());
// personRepository.save(existingPerson);
// saveToHashMap(existingPerson);
// }
// }

// public void deletePerson(String id) {
// personRepository.deleteById(id);
// deleteFromHashMap(id);
// }

// public Optional<Person> getPerson(String id) {
// Optional<Person> personFromHashMap = getFromHashMap(id);
// return personFromHashMap.isPresent() ? personFromHashMap :
// personRepository.findById(id);
// }

// public Iterable<Person> getAllPersonsFromHashMap() {
// return personHashMap.values();
// }

// private void saveToHashMap(Person person) {
// personHashMap.put(person.getId(), person);
// }

// private void deleteFromHashMap(String id) {
// personHashMap.remove(id);
// }

// private Optional<Person> getFromHashMap(String id) {
// return Optional.ofNullable(personHashMap.get(id));
// }
// }

// package com.example.demo.service;

// import java.util.Optional;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;

// import com.example.demo.Repo.PersonRepository;
// import com.example.demo.model.Person;

// @Service
// public class PersonService {
// private final PersonRepository personRepository;

// @Autowired
// public PersonService(PersonRepository personRepository) {
// this.personRepository = personRepository;
// }

// public Person savePerson(Person person) {
// return personRepository.save(person);
// }

// public Optional<Person> getPerson(String id) {
// return personRepository.findById(id);
// }

// public Iterable<Person> getAllPersons() {
// return personRepository.findAll();
// }

// public void deletePerson(String id) {
// personRepository.deleteById(id);
// }
// }
