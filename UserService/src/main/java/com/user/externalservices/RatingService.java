package com.user.externalservices;

import com.user.entities.Rating;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@FeignClient(name = "RATING-SERVICE")
@Service
public interface RatingService {

    @PostMapping("/rating")
    Rating createRating(Rating rating);

    @GetMapping("/rating/user/{userId}")
    Rating[] getRatingsofUser(@PathVariable String userId);

    @PutMapping("/rating/{ratingId}")
    Rating upadateRating(@PathVariable String ratingId, Rating rating);


}
