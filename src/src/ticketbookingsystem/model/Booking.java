package ticketbookingsystem.model;

import java.util.ArrayList;
import java.util.List;

enum BookingStatus{
    CREATED,CONFIRMED, EXPIRED;
}

public class Booking {

    private String id;
    private Show show;
    private List<Seat> seatsBooked;
    private String userId;
    private BookingStatus bookingStatus;


    public Booking(String id, Show show, List<Seat> seatsBooked, String userId, BookingStatus bookingStatus) {
        this.id = id;
        this.show = show;
        this.seatsBooked = new ArrayList<>();
        this.userId = userId;
        this.bookingStatus = BookingStatus.CREATED;
    }

    public boolean isConfirmed(){
        return this.bookingStatus == BookingStatus.CONFIRMED;
    }

    public void confirmBooking(){
        if(this.bookingStatus != BookingStatus.CREATED){
            // throw invalid state exception
        }
        this.bookingStatus = BookingStatus.CONFIRMED;
    }

    public void expireBooking(){
        this.bookingStatus = BookingStatus.EXPIRED;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Show getShow() {
        return show;
    }

    public void setShow(Show show) {
        this.show = show;
    }

    public List<Seat> getSeatsBooked() {
        return seatsBooked;
    }

    public void setSeatsBooked(List<Seat> seatsBooked) {
        this.seatsBooked = seatsBooked;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public BookingStatus getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(BookingStatus bookingStatus) {
        this.bookingStatus = bookingStatus;
    }
}
