package com.mytests.micronaut;

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
public class AdminService {
    
    @Inject PersonsRepository repository;
    
    @Cacheable({"admins"})
    public List<Person> getAdmins(){
        List<Person> admins = new ArrayList<>();
        try {
            TimeUnit.SECONDS.sleep(3);
            System.out.println("===============");
            System.out.println("AdminService.getAdmins() called");
            System.out.println("===============");
            for (Person person : repository.persons) {
                if(person.role.equals("admin")){
                    admins.add(person);
                }
            }
            return admins;
        } catch (InterruptedException e) {
            return null;
        }
    }
    @CachePut({"admins"})
    public List<Person> updateAndGet(String name){
        List<Person> admins = new ArrayList<>();
        repository.addPerson(name,"admin");
        List<Person> persons = repository.getAll();
        
        for (Person person : persons) {
            if(person.role.equals("admin") && !person.name.equals(name)){
                admins.add(person);
            }
        }
        admins.add(persons.get(persons.size()-1));
        return admins;
    }
}
