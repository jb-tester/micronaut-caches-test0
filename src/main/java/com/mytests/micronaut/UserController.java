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
@Controller("/users")
public class UserController {
    @Inject UserService service;
    @Get
    public List<Person> getAllUsers(){
       return service.getUsers(); 
    }
    @Get("/{name}")
    public List<Person> getAndAddUsers(@PathVariable String name){
        return service.updateAndGet(name);
    }
}
