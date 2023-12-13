package com.example.demo.Repo;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Person;

public interface PersonRepository extends CrudRepository<Person, String> {
    // You can add custom queries or methods here if needed
}
