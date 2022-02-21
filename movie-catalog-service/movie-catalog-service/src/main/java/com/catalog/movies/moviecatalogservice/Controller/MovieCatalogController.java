package com.catalog.movies.moviecatalogservice.Controller;

import com.catalog.movies.moviecatalogservice.Models.CatalogItem;
import com.catalog.movies.moviecatalogservice.Models.Movie;
import com.catalog.movies.moviecatalogservice.Models.Rating;
import com.catalog.movies.moviecatalogservice.Models.UserRating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/{userId}")
    public List<CatalogItem> getCatalog(@PathVariable("userId") String userId){

        UserRating ratings = restTemplate.getForObject("http://movie-rating-data-service/ratingsdata/users/"+ userId, UserRating.class);

        return ratings.getUserRating().stream().map(rating -> {

            //for each movie id, call movie info service and get details
            Movie movie = restTemplate.getForObject("http://movie-info-service/movies/"+ rating.getMovieId(), Movie.class); //Using REST template
            //put them all together
            return new CatalogItem(movie.getName(), movie.getDescription(), rating.getRating());

        }).collect(Collectors.toList());

//        return Collections.singletonList(
//                new CatalogItem("Dolittle", "Adventure movie", 8)
//        );
    }
}
