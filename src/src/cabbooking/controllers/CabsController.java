package cabbooking.controllers;

import cabbooking.managers.CabsManager;
import cabbooking.managers.TripsManager;
import cabbooking.model.Cab;
import cabbooking.model.Location;

public class CabsController {

    private CabsManager cabsManager;
    private TripsManager tripsManager;

    public CabsController(CabsManager cabsManager, TripsManager tripsManager) {
        this.cabsManager = cabsManager;
        this.tripsManager = tripsManager;
    }

    /**
     * api for registering a new cab in cab database
     * @param cabId
     * @param driverName
     */
    public void regiserCab(final String cabId, final String driverName) {
        cabsManager.createCab(new Cab(cabId, driverName));
    }

    /**
     * api for updating cab location
     * @param cabId
     * @param newX
     * @param newY
     */
    public void updateCabLocation(
            final String cabId, final Double newX, final Double newY) {

        cabsManager.updateCabLocation(cabId, new Location(newX, newY));
    }

    /**
     * api for updating cab availablity
     * @param cabId
     * @param newAvailability
     */
    public void updateCabAvailability(final String cabId, final Boolean newAvailability) {
        cabsManager.updateCabAvailablity(cabId, newAvailability);
    }

    /**
     * api for ending trip for an ongoing trip
     * @param cabId
     */
    public void endTrip(final String cabId) {
        tripsManager.endTrip(cabsManager.getCab(cabId));
    }
}
