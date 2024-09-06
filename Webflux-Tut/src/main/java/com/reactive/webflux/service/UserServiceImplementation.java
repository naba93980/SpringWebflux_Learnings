package com.reactive.webflux.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reactive.webflux.entities.User;
import com.reactive.webflux.repositories.UserRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UserServiceImplementation implements UserService {

   
    @Autowired
    private UserRepository userRepository;

    @Override
    public Mono<User> createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public Mono<User> getUser(Long userId) {
        return userRepository.findById(userId);
    }

    @Override
    public Flux<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Mono<User> updateUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public Mono<Void> deleteUser(Long userId) {
        return userRepository.deleteById(userId);
    }

}
