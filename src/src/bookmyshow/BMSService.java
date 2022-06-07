package bookmyshow;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class BMSService {

    List<CinemaHall> cinemaHalls;

    public List<Movie> getMovies(Date date, String city){
        return null;
    }
    public List<CinemaHall> getCinemaHalls(String city){
        return null;
    }
}

class CinemaHall{

    int cinemaHallId;
    String cinemaName;
    Address address;
    List<Audi> audiList;

}

class Address{
    int pinCode;
    String street;
    String city;
    String state;
    String country;
}

class Audi{

    int audiId;
    String audiName;
    int totalSeats;
    List<Show> shows;
}

class Show{

    int showId;
    Movie movie;
    Date startTime;
    Date endTime;

    CinemaHall cinemaPlayedAt;
    List<Seat> seats;
}

class Seat{

    int seatId;
    SeatType seatType;
    SeatStatus seatStatus;
    Double price;
}

enum SeatType{
    DELUXE, ECONOMY, OTHER;
}

enum SeatStatus{
    BOOKED, AVAILABLE, NOT_AVAILABLE;
}

class Movie{

    String movieName;
    int movieId;
    int durationInMins;
    String language;
    Date releaseDate;

    Map<String, List<Show>> cityShowMap;
}

class Search{

    public List<Movie> searchMovieByName(String name){
        return new ArrayList<>();
    }
    public List<Movie> searchMovieByLangugage(String language){
        return new ArrayList<>();
    }
    public List<Movie> searchMovieByReleaseDate (Date date){
        return new ArrayList<>();
    }
}

class User{

    int userId;
    Search searchObj;
}

class SystemMember extends User{

    Account account;
    String name;
    String email;
    Address address;
}

class Account{

    String userName;
    String password;
}

class Member extends SystemMember{

    public Booking makeBooking(Booking booking){
          return new Booking();
    }

    public List<Booking> getBooking(){
        return new ArrayList<>();
    }
}

class Admin extends SystemMember{

    public boolean addMovie(Movie movie){
        return true;
    }
    public boolean addShow(Movie movie){
        return true;
    }
}

class Booking{

    String bookingId;
    Date bookingDate;
    Show show;
    Audi  audi;
    BookingStatus bookingStatus;
    double totalAmount;
    List<Seat> seats;
    Payment paymentObj;

    boolean makePayment(Payment paymentObj){
        return true;
    }
}

enum BookingStatus{
      CONFIRMED, CANCELLED, PENDING, REQUESTED;
}

class Payment{
    double amount;
    Date paymentDate;
    String transactionId;
    PaymentStatus status;
}

enum PaymentStatus{
    PAID, DECLINED, PENDING, CANCELLED, REFUNDED;
}



