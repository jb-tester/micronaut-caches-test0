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
public class NameController {
    @Inject NameService service;
    @Get("/names/{role}")
    public List<String> getAllNames(String role){
       return service.getPersonNamesByRole(role); 
    }
    @Get("/names/{name}/{role}")
    public List<String> getAndAddUsers(@PathVariable String name, @PathVariable String role){
        return service.updateAndGet(name, role);
    }
    
}
