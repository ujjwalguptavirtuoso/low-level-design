package cabbooking.strategies;

import cabbooking.model.Location;

public class DefaultPricingStrategy implements PricingStrategy{

    public static final Double PER_KM_RATE = 10.0;

    @Override
    public Double findPrice(Location startPoint, Location toPoint) {
        return startPoint.distance(toPoint) * PER_KM_RATE;
    }
}
