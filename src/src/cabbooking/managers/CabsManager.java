package cabbooking.managers;

import cabbooking.model.Cab;
import cabbooking.model.Location;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CabsManager {
    /**
     * In memory database for cabs, cabId vs cab stored
     */
    Map<String, Cab> map = new HashMap<>();

    public void createCab(final Cab newCab){
        if(map.containsKey(newCab.getId())){
           //throw some exception // duplicate cab registring
        }
        map.put(newCab.getId(), newCab);
    }

    public Cab getCab(final String cabId){
        if(!map.containsKey(cabId)){
            //throw some cab not found exception
        }
        return map.get(cabId);
    }

    public void updateCabLocation(final String cabId, final Location location){
        if(!map.containsKey(cabId)){
            //throw some cab not found exception
        }
        Cab cab = map.get(cabId);
        cab.setCurrentLocation(location);
    }

    public void updateCabAvailablity(final String cabId, final Boolean availability){
        if(!map.containsKey(cabId)){
            //throw some cab not found exception
        }
        Cab cab = map.get(cabId);
        cab.setAvailable(availability);
    }

    public List<Cab> getCabs(final Location fromPoint, final Double distance) {
        List<Cab> result = new ArrayList<>();
        for (Cab cab : map.values()) {
            // TODO: Use epsilon comparison because of double
            if (cab.getAvailable() && cab.getCurrentLocation().distance(fromPoint) <= distance) {
                result.add(cab);
            }
        }
        return result;
    }

}
