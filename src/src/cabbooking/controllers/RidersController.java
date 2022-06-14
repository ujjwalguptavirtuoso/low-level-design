package cabbooking.controllers;


import cabbooking.managers.RidersManager;
import cabbooking.managers.TripsManager;
import cabbooking.model.Location;
import cabbooking.model.Rider;
import cabbooking.model.Trip;

import java.util.List;

public class RidersController {
    private RidersManager ridersManager;
    private TripsManager tripsManager;

    public RidersController(RidersManager ridersManager, TripsManager tripsManager) {
        this.ridersManager = ridersManager;
        this.tripsManager = tripsManager;
    }

    /**
     * api for registring a new rider
     * @param riderId
     * @param riderName
     */
    public void registerRider(final String riderId, final String riderName) {
        ridersManager.createRider(new Rider(riderId, riderName));

    }

    /**
     * api for booking cab
     * @param riderId
     * @param sourceX
     * @param sourceY
     * @param destX
     * @param destY
     */
    public void book(
            final String riderId,
            final Double sourceX,
            final Double sourceY,
            final Double destX,
            final Double destY) {

        tripsManager.createTrip(
                ridersManager.getRider(riderId),
                new Location(sourceX, sourceY),
                new Location(destX, destY));

    }

    /**
     * api for fetching trips history for a rider
     * @param riderId
     * @return
     */
    public List<Trip> fetchHistory(final String riderId) {
        List<Trip> trips = tripsManager.tripHistory(ridersManager.getRider(riderId));
        return trips;
    }
}
