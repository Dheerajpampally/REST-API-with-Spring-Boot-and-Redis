
package com.example.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import lombok.Data;

@Data
@RedisHash("Person")
public class Person {
    @Id
    private String id;
    private String name;
    private int age;

    // Constructors, getters, and setters
}
