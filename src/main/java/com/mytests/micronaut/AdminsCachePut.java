package com.mytests.micronaut;

import io.micronaut.cache.annotation.CacheAnnotation;
import io.micronaut.cache.annotation.CacheConfig;
import io.micronaut.cache.annotation.CachePut;
import io.micronaut.cache.annotation.PutOperations;
import io.micronaut.cache.interceptor.CacheInterceptor;
import io.micronaut.context.annotation.AliasFor;
import io.micronaut.context.annotation.Type;

import java.lang.annotation.*;

/**
 * *
 * <p>Created by irina on 12.03.2021.</p>
 * <p>Project: micronaut-caches-test0</p>
 * *
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@CachePut("admins")
public @interface AdminsCachePut {
    @AliasFor(annotation = CachePut.class, member = "parameters")
    String[] parameters() default {};
}
