package com.reactive.webflux;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.reactive.webflux.handlers.UserHandler;

@SpringBootApplication
@EnableWebFlux
public class WebfluxTutApplication {


	@Bean
    public RouterFunction<ServerResponse> route(UserHandler userHandler) {
        return RouterFunctions.route()
                .GET("/allUsers", userHandler::getAllUsers)
                .build();
    }
	public static void main(String[] args) {
		SpringApplication.run(WebfluxTutApplication.class, args);
	}

}
