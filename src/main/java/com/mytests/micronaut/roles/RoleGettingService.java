package com.mytests.micronaut.roles;

import com.mytests.micronaut.Person;
import com.mytests.micronaut.PersonsRepository;
import io.micronaut.cache.annotation.Cacheable;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * *
 * <p>Created by irina on 07.04.2021.</p>
 * <p>Project: micronaut-caches-test0</p>
 * *
 */
@Singleton
public class RoleGettingService extends RoleService {

    @Inject
    PersonsRepository repository;

    @Cacheable
    public Set<String> getPersonRoles(){
        try {
            TimeUnit.SECONDS.sleep(3);
            System.out.println("===============");
            System.out.println("RoleGettingService.getPersonRoles() called");
            System.out.println("===============");
            Set<String> roles = new HashSet<>();
            for (Person person : repository.getAll()) {
                roles.add(person.getRole());
            }
            return roles;
        } catch (InterruptedException e) {
            return null;
        }
    } 
}
