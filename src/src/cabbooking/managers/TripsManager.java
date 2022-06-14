package cabbooking.managers;

import cabbooking.model.Cab;
import cabbooking.model.Location;
import cabbooking.model.Rider;
import cabbooking.model.Trip;
import cabbooking.strategies.CabMatchingStrategy;
import cabbooking.strategies.PricingStrategy;

import java.util.*;

public class TripsManager {

    public static final Double MAX_ALLOWED_TRIP_MATCHING_DISTANCE = 10.0;
    private Map<String, List<Trip>> trips = new HashMap<>();

    private CabsManager cabsManager;
    private RidersManager ridersManager;
    private CabMatchingStrategy cabMatchingStrategy;
    private PricingStrategy pricingStrategy;

    public TripsManager(CabsManager cabsManager, RidersManager ridersManager, CabMatchingStrategy cabMatchingStrategy, PricingStrategy pricingStrategy) {
        this.cabsManager = cabsManager;
        this.ridersManager = ridersManager;
        this.cabMatchingStrategy = cabMatchingStrategy;
        this.pricingStrategy = pricingStrategy;
    }

    public void createTrip(Rider rider, Location startPoint, Location endPoint) {
        /**
         * first getting all nearby buy cabs with location constraints
         */
        List<Cab> nearbyCabs = cabsManager.getCabs(startPoint, MAX_ALLOWED_TRIP_MATCHING_DISTANCE);

        List<Cab> availableCabs = new ArrayList<>();
        /**
         *  finding available cabs from nearby cabs
         */
        for (Cab cab : nearbyCabs) {
            if (cab.getAvailable() && cab.getCurrentTrip() == null) {
                availableCabs.add(cab);
            }
        }

       /**
        * matching cab to a rider internal logic
        */
       Cab selectedCab = cabMatchingStrategy.matchCabToRider(rider, availableCabs, startPoint, endPoint);

        Double price = pricingStrategy.findPrice(startPoint, endPoint);
        Trip newTrip = new Trip(rider, selectedCab, price, startPoint, endPoint);
        if (!trips.containsKey(rider.getId())) {
            trips.put(rider.getId(), new ArrayList<>());
        }
        trips.get(rider.getId()).add(newTrip);
        selectedCab.setCurrentTrip(newTrip);
    }


   public List<Trip> tripHistory(final Rider rider) {
      return trips.get(rider.getId());
   }

   public void endTrip( final Cab cab) {
      if (cab.getCurrentTrip() == null) {
         //throw new TripNotFoundException();
      }

      cab.getCurrentTrip().endTrip();
      cab.setCurrentTrip(null);
   }


}
