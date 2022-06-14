package cabbooking.model;

enum TripStatus{
    BOOKED,IN_PROGRESS, FINISHED;
}

public class Trip {

    private Rider rider;
    private Cab cab;
    private TripStatus tripStatus;
    Double price;
    Location fromPoint;
    Location toPoint;

    public Trip(Rider rider, Cab cab, Double price, Location fromPoint, Location toPoint) {
        this.rider = rider;
        this.cab = cab;
        this.price = price;
        this.fromPoint = fromPoint;
        this.toPoint = toPoint;
        this.tripStatus = TripStatus.BOOKED;
    }

    public void startTrip(){
        this.tripStatus = TripStatus.IN_PROGRESS;
    }

    public void endTrip(){
        this.tripStatus = TripStatus.FINISHED;
    }
}
