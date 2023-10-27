package com.rating.service;

import com.rating.entities.Rating;

import java.util.List;

public interface RatingService {

    Rating createRating(Rating rating);
    List<Rating> getAllRatings();

    List<Rating>getRatingByUser(String userId);

    List<Rating> getRatingByHotelId(String hotelId);
}
