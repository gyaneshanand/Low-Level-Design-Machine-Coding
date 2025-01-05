package VehicleRentalSystem.util.pricingStrategy;

import VehicleRentalSystem.dto.Pricing;
import VehicleRentalSystem.model.Vehicle;

public interface PricingStrategy {
    public boolean setPrice(Vehicle vehicle, Pricing pricing);
}
