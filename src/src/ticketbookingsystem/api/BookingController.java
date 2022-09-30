package ticketbookingsystem.api;

import ticketbookingsystem.model.Seat;
import ticketbookingsystem.model.Show;
import ticketbookingsystem.services.BookingService;
import ticketbookingsystem.services.ShowService;
import ticketbookingsystem.services.TheatreService;

import java.util.ArrayList;
import java.util.List;

public class BookingController {

    private ShowService showService;
    private BookingService bookingService;
    private TheatreService theatreService;

    public BookingController(ShowService showService, BookingService bookingService, TheatreService theatreService) {
        this.showService = showService;
        this.bookingService = bookingService;
        this.theatreService = theatreService;
    }

    public String createBooking(String userId, String showId, List<String> seatIds){
        Show show = showService.getShow(showId);
        List<Seat> seats = new ArrayList<>();
        for(String seatId : seatIds){
            seats.add(theatreService.getSeat(seatId));
        }
        return bookingService.createBooking(userId, show, seats).getId();
    }
}
