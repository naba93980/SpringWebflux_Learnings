package com.reactive.webflux.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.reactive.webflux.entities.User;
import com.reactive.webflux.service.UserServiceImplementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.ReactiveSecurityContextHolder;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import reactor.core.publisher.Mono;


@RestController
@RequestMapping("/users")
@NoArgsConstructor
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class UserController {

    private UserServiceImplementation userService;
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @GetMapping("/getUser")
    public Mono<User> getUser(@RequestParam Long userId) {
        logger.info("Received request to get user");
        return userService.getUser(userId);
    }

    @PostMapping("/createUser")
    public Mono<User> createUser(@RequestBody User user) {
        logger.info("Received request to create user");
        ReactiveSecurityContextHolder.getContext().map(context -> context.getAuthentication()).subscribe(auth -> {
            logger.info("User: " + auth.getName());
        });
        return userService.createUser(user);
    }
}
