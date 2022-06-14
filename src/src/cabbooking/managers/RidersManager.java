package cabbooking.managers;

import cabbooking.model.Rider;

import java.util.HashMap;
import java.util.Map;

public class RidersManager {

    /**
     * In memory database for riders
     */
    Map<String, Rider> riders = new HashMap<>();

    public void createRider(Rider rider){
        if(riders.containsKey(rider.getId())){
            // throw some exception // duplicate rider
        }
        riders.put(rider.getId(), rider);
    }

    public Rider getRider(final String riderId){
        if(!riders.containsKey(riderId)){
            //throw some rider not found exception
        }
        return riders.get(riderId);
    }
}
