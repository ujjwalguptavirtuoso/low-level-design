package ticketbookingsystem.services;

import ticketbookingsystem.model.Seat;
import ticketbookingsystem.model.Show;
import ticketbookingsystem.provider.SeatLockProvider;

import java.util.ArrayList;
import java.util.List;

public class SeatAvailablityService {

    private BookingService bookingService;
    private SeatLockProvider seatLockProvider;

    public SeatAvailablityService(BookingService bookingService, SeatLockProvider seatLockProvider) {
        this.bookingService = bookingService;
        this.seatLockProvider = seatLockProvider;
    }

    List<Seat> getAvailableSeats(Show show){
        List<Seat> allSeats = show.getScreen().getSeatList();
        List<Seat> unavailableSeats = getUnavailableSeats(show);

        List<Seat> availableSeats = new ArrayList<>(allSeats);
        availableSeats.removeAll(unavailableSeats);
        return allSeats;
    }

    private List<Seat> getUnavailableSeats(Show show){
        List<Seat> unavailableSeats = bookingService.getBookedSeats(show);
        unavailableSeats.addAll(seatLockProvider.getLockedSeats(show));

        return unavailableSeats;
    }
}
