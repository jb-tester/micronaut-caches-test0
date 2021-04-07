package com.mytests.micronaut.roles;

import com.mytests.micronaut.Person;
import com.mytests.micronaut.PersonsRepository;
import io.micronaut.cache.annotation.CachePut;

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
public class RoleUpdatingService extends RoleService {

    @Inject
    PersonsRepository repository;

    @CachePut(parameters = "role")
    public Set<String> addPersonWithNewRoleAndGetRoles(String name, String role){
        try {
            TimeUnit.SECONDS.sleep(3);
            System.out.println("===============");
            System.out.println("RoleUpdatingService.addPersonWithNewRole("+name+", "+role+") called");
            System.out.println("===============");
            repository.addPerson(name,role);
            
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
