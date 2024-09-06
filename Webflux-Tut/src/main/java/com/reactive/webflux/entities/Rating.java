package com.reactive.webflux.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import reactor.core.publisher.Mono;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Rating {

    private String ratingId;
    private Long userId;
    private Long hotelId;
    private Mono<Hotel> hotel; // Use Mono for reactive hotel data
    private int rating;
    private String feedback;
}
