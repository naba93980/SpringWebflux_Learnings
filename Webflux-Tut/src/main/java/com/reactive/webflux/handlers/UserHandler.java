package com.reactive.webflux.handlers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.reactive.webflux.entities.User;
import com.reactive.webflux.service.UserService;

import reactor.core.publisher.Mono;

@Component
public class UserHandler {

    @Autowired
    private UserService userService;
    private static final Logger logger = LoggerFactory.getLogger(UserHandler.class);


    public Mono<ServerResponse> getAllUsers(ServerRequest request) {
        logger.info("Received request to get all users");
        return ServerResponse.ok().body(userService.getAllUsers(), User.class);
    }
}

