package com.user.service.impl;

import com.user.entities.Hotel;
import com.user.entities.Rating;
import com.user.entities.User;
import com.user.exceptions.ResourceNotFoundException;
import com.user.externalservices.HotelService;
import com.user.externalservices.RatingService;
import com.user.repository.UserRepository;
import com.user.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl  implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private HotelService hotelService;
    @Autowired
    private RatingService ratingService;
    @Autowired
    private RestTemplate restTemplate;

    private Logger logger= LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public User saveUser(User user) {
//        generate Unique UserId
        String id = UUID.randomUUID().toString();
        user.setUserId(id);
        return this.userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(String id) {
        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("user with given Id " + id + " is not found !"));

//        Rating[] ratingsOfUser = restTemplate.getForObject("http://RATING-SERVICE/rating/user/"+id, Rating[].class)

        Rating[] ratingsOfUser = ratingService.getRatingsofUser(id);

        logger.info("{} ",ratingsOfUser);

        List<Rating> ratings = Arrays.stream(ratingsOfUser).toList();
        List<Rating>  ratingList=ratings.stream().map(rate ->{
//          api call to hotel service to get the hotel+

//          ResponseEntity<Hotel> hotelEntity = restTemplate.getForEntity("http://HOTEL-SERVICE/hotel/"+rate.getHotelId(), Hotel.class);
//          Hotel hotel = hotelEntity.getBody();
            Hotel hotel = hotelService.getHotel(rate.getHotelId());

            //            set hotel to rating
          rate.setHotel(hotel);
          return rate;
        }).collect(Collectors.toList());

        user.setRatings(ratingList);
        return user;
    }

    @Override
    public void deleteUser(String id) {
     userRepository.deleteById(id);
    }

}
