package com.reactive.webflux.entities;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;



import org.springframework.data.annotation.Transient;
import reactor.core.publisher.Flux;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table("users_table")
public class User {

    @Id
    private Long userId;
    private String name;
    private String email;
    private String about;
    
    @Transient
    private Flux<Rating> ratings;
}
