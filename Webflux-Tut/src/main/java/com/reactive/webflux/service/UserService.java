package com.reactive.webflux.service;

import com.reactive.webflux.entities.User;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


public interface UserService {
    
    Mono<User> createUser(User user);

    Mono<User> getUser(Long userId);

    Flux<User> getAllUsers();

    Mono<User> updateUser(User user);

    Mono<Void> deleteUser(Long userId);
     
}
