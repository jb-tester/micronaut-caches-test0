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
public class NameService {
    
    @Inject PersonsRepository repository;
    
    @Cacheable(cacheNames = "names", parameters = "role")
    public List<String> getPersonNamesByRole(String role){
        try {
            TimeUnit.SECONDS.sleep(3);
            System.out.println("===============");
            System.out.println("NameService.getPersonNamesByRole("+role+") called");
            System.out.println("===============");
            List<String> names = new ArrayList<>();
            for (Person person : repository.getAll()) {
                if (person.role.equals(role)){
                    names.add(person.getName());
                }
            }
            return names;
        } catch (InterruptedException e) {
            return null;
        }
    }
    @CachePut(value = {"names"}, parameters = {"role"})
    public List<String> updateAndGet(String name, String role){
       
        repository.addPerson(name,role);
        List<String> names = new ArrayList<>();
        for (Person person : repository.getAll()) {
            if (person.role.equals(role)){
                names.add(person.getName());
            }
        }
        return names;
    }
    
  
}
