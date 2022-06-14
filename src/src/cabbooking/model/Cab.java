package cabbooking.model;

public class Cab {

    String id;
    String driverName;

    Boolean isAvailable;
    Location currentLocation;
    Trip currentTrip;

    public Cab(String id, String driverName) {
        this.id = id;
        this.driverName = driverName;
        this.isAvailable = true;
    }

    public String getId() {
        return id;
    }

    public String getDriverName() {
        return driverName;
    }

    public Boolean getAvailable() {
        return isAvailable;
    }

    public Location getCurrentLocation() {
        return currentLocation;
    }

    public Trip getCurrentTrip() {
        return currentTrip;
    }

    public void setAvailable(Boolean available) {
        isAvailable = available;
    }

    public void setCurrentLocation(Location currentLocation) {
        this.currentLocation = currentLocation;
    }

    public void setCurrentTrip(Trip currentTrip) {
        this.currentTrip = currentTrip;
    }
}
