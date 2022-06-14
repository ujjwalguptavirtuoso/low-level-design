package cabbooking.strategies;

import cabbooking.model.Location;

public interface PricingStrategy {

    Double findPrice( Location startPoint, Location toPoint);
}
