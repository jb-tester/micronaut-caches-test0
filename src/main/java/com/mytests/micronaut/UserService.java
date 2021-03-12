package com.mytests.micronaut;

import io.micronaut.cache.annotation.CacheConfig;
import io.micronaut.cache.annotation.CachePut;
import io.micronaut.cache.annotation.Cacheable;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * *
 * <p>Created by irina on 12.03.2021.</p>
 * <p>Project: micronaut-caches-test0</p>
 * *
 */
@Singleton
@CacheConfig(cacheNames = {"users"})
public class UserService {
    
    @Inject PersonsRepository repository;
    @Cacheable
    public List<Person> getUsers(){
        List<Person> users = new ArrayList<>();
        try {
            TimeUnit.SECONDS.sleep(3);
            System.out.println("===============");
            System.out.println("UserService.getUsers() called");
            System.out.println("===============");
            for (Person person : repository.persons) {
                if(person.role.equals("user")){
                    users.add(person);
                }
            }
            return users;
        } catch (InterruptedException e) {
            return null;
        }
    }
    @CachePut
    public List<Person> updateAndGet(String name){
        List<Person> users = new ArrayList<>();
        repository.addPerson(name,"user");
        List<Person> persons = repository.getAll();
        
        for (Person person : persons) {
            if(person.role.equals("user") && !person.name.equals(name)){
                users.add(person);
            }
        }
        users.add(persons.get(persons.size()-1));
        return users;
    }
}
