package com.mytests.micronaut;

import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.List;

/**
 * *
 * <p>Created by irina on 12.03.2021.</p>
 * <p>Project: micronaut-caches-test0</p>
 * *
 */
@Singleton
public class PersonsRepository {


    List<Person> persons = new ArrayList<>(){{
        add(new Person(1,"vasya","admin"));
        add(new Person(2,"valya","admin"));
        add(new Person(3,"vanya","admin"));
        add(new Person(4,"dasha","user"));
        add(new Person(5,"sasha","user"));
        add(new Person(6,"pasha","user"));
        add(new Person(7,"masha","user"));
    }};
    public List<Person> getAll(){
        return persons;
    }

    public void addPerson(String name, String role) {
        persons.add(new Person(persons.size()+1,name,role));
    }
}
