package com.data.rating.movies.movieratingdataservice.Controller;

import com.data.rating.movies.movieratingdataservice.Models.Rating;
import com.data.rating.movies.movieratingdataservice.Models.UserRating;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/ratingsdata")
public class MovieRatingDataController {

    @RequestMapping("/{movieId}")
    public Rating getRating(@PathVariable String movieId){

        return new Rating(movieId, 8);
    }

    @RequestMapping("users/{userId}")
    public UserRating getUserRating(@PathVariable String userId){
        List<Rating> ratings = Arrays.asList(
                new Rating("9876", 7),
                new Rating("5432", 3)
        );
        UserRating userRating = new UserRating();
        userRating.setUserRating(ratings);

        return userRating;
    }
}
