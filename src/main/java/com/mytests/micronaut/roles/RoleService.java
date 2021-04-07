package com.mytests.micronaut.roles;

import io.micronaut.cache.annotation.CacheConfig;
import io.micronaut.cache.annotation.CacheInvalidate;

import javax.inject.Singleton;

/**
 * *
 * <p>Created by irina on 07.04.2021.</p>
 * <p>Project: micronaut-caches-test0</p>
 * *
 */
@Singleton
@CacheConfig("roles")
public class RoleService {
    
   @CacheInvalidate
   public void clearRoles(){
       System.out.println("roles cache has been incalidated!");
   } 
}
