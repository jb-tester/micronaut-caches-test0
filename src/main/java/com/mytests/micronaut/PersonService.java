package com.mytests.micronaut;

import io.micronaut.cache.annotation.CacheInvalidate;
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
public class PersonService {
    
    @Inject PersonsRepository repository;
    
    @Cacheable({"admins","users","persons"})
    public List<Person> getPersons(){
        try {
            TimeUnit.SECONDS.sleep(3);
            System.out.println("===============");
            System.out.println("PersonService.getPersons() called");
            System.out.println("===============");
            return new ArrayList<>(repository.persons);
        } catch (InterruptedException e) {
            return null;
        }
    }
    @CachePut({"persons"})
    public List<Person> updateAndGet(String name, String role){
       
        repository.addPerson(name,role);
        
        return repository.getAll();
    }
    
    @CacheInvalidate("persons")
    @CacheInvalidate("users")
    @CacheInvalidate("admins")
    public void removeCaches(){
        System.out.println("!!!! all caches removed !!!!");
    }
}
