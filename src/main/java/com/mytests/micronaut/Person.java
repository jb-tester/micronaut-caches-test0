package com.mytests.micronaut;

import io.micronaut.core.annotation.Introspected;

/**
 * *
 * <p>Created by irina on 12.03.2021.</p>
 * <p>Project: micronaut-caches-test0</p>
 * *
 */
@Introspected
public class Person {
    Integer id;
    String name;
    String role;

    public Person(Integer id, String name, String role) {
        this.id = id;
        this.name = name;
        this.role = role;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }

    @Override
    public String toString() {
        return "Person: " +
                "id=" + id +
                ", name='" + name +
                ", role='" + role ;
    }
}
