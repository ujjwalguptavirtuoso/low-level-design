package ticketbookingsystem.api;

import ticketbookingsystem.model.Movie;
import ticketbookingsystem.model.Screen;
import ticketbookingsystem.model.Seat;
import ticketbookingsystem.model.Show;
import ticketbookingsystem.services.MovieService;
import ticketbookingsystem.services.TheatreService;

import java.util.ArrayList;
import java.util.List;

public class ShowController {

    TheatreService theatreService;
    MovieService movieService;

    public ShowController(TheatreService theatreService, MovieService movieService) {
        this.theatreService = theatreService;
        this.movieService = movieService;
    }

    public void createShow(String movieId, String screenId, Integer durationInSeconds){
        Screen screen = theatreService.getScreen(screenId);
        Movie movie = movieService
    }

    public List<Seat> getAvailableSeats(String showId){
        return new ArrayList<>();
    }



    public List<Seat> getUnavailableSeats(Show show)
}
