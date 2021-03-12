package com.mytests.micronaut;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.PathVariable;

import javax.inject.Inject;
import java.util.List;

/**
 * *
 * <p>Created by irina on 12.03.2021.</p>
 * <p>Project: micronaut-caches-test0</p>
 * *
 */
@Controller
public class PersonController {
    @Inject PersonService service;
    @Get("/persons")
    public List<Person> getAllUsers(){
       return service.getPersons(); 
    }
    @Get("/persons/{name}/{role}")
    public List<Person> getAndAddUsers(@PathVariable String name, @PathVariable String role){
        return service.updateAndGet(name, role);
    }
    @Get("/remove")
    public String removeAll(){
        
        service.removeCaches();
        return "all caches were purged";
    }
}
