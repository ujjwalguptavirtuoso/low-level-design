package cabbooking.strategies;

import cabbooking.model.Cab;
import cabbooking.model.Location;
import cabbooking.model.Rider;

import java.util.List;

public interface CabMatchingStrategy {

    Cab matchCabToRider(Rider rider, List<Cab> candidateCabs, Location startPoint, Location toPoint);
}
