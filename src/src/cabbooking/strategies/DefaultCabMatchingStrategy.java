package cabbooking.strategies;

import cabbooking.model.Cab;
import cabbooking.model.Location;
import cabbooking.model.Rider;

import java.util.List;

public class DefaultCabMatchingStrategy implements CabMatchingStrategy{


    @Override
    public Cab matchCabToRider(Rider rider, List<Cab> candidateCabs, Location startPoint, Location toPoint) {
        return candidateCabs.get(0);
    }
}
