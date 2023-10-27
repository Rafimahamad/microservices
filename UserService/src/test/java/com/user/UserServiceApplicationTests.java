package com.user;

import com.user.entities.Rating;
import com.user.externalservices.RatingService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserServiceApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
    private RatingService ratingService;

	@Test
	void createRating(){
		Rating rating = Rating.builder().rating(4).userId("").hotelId("").feedback("this is created for testing").build();
		Rating rating1 = ratingService.createRating(rating);
		System.out.println("new Rating is created");

	}
}
