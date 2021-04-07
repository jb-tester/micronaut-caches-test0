package com.mytests.micronaut.roles;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.PathVariable;

import javax.inject.Inject;
import java.util.Set;

/**
 * *
 * <p>Created by irina on 07.04.2021.</p>
 * <p>Project: micronaut-caches-test0</p>
 * *
 */
@Controller("/roles")
public class RolesController {
    @Inject RoleGettingService gettingService;
    @Inject  RoleUpdatingService updatingService;
    
    @Get("/all")
    public Set<String> getAllRoles() {
        
        return gettingService.getPersonRoles();
    }
    @Get("/add/{name}/{role}")
    public Set<String> getAndAddRoles(@PathVariable String name, @PathVariable String role) {
        
        return updatingService.addPersonWithNewRoleAndGetRoles(name,role);
    }


}
