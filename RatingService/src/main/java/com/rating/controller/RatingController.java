package com.rating.controller;

import com.rating.entities.Rating;
import com.rating.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/rating")
public class RatingController {

    @Autowired
    private RatingService service;

    @PostMapping("/")
    public ResponseEntity<Rating> create(@RequestBody Rating rating){
     return  ResponseEntity.status(HttpStatus.CREATED).body(service.createRating(rating));
    }

    @GetMapping("/")
    public ResponseEntity<List<Rating>> getAllRatings(){
        return ResponseEntity.status(HttpStatus.OK).body(service.getAllRatings());
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Rating>> getRatingsByUser(@PathVariable String userId){
        return ResponseEntity.status(HttpStatus.OK).body(service.getRatingByUser(userId));
    }

    @GetMapping("/hotel/{hotelId}")
    public ResponseEntity<List<Rating>> getRatingsByHotel(@PathVariable String hotelId){
        return ResponseEntity.status(HttpStatus.OK).body(service.getRatingByHotelId(hotelId));
    }
}
