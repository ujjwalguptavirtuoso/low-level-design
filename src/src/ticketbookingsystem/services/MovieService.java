package ticketbookingsystem.services;

import ticketbookingsystem.model.Movie;

import java.util.HashMap;
import java.util.Map;

public class MovieService {

    Map<String, Movie> movieMap;

    public MovieService(Map<String, Movie> movieMap) {
        this.movieMap = new HashMap<>();
    }


}
