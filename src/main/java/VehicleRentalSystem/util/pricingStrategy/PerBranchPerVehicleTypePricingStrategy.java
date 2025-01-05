package VehicleRentalSystem.util.pricingStrategy;

import VehicleRentalSystem.dto.Pricing;
import VehicleRentalSystem.model.Vehicle;

public class PerBranchPerVehicleTypePricingStrategy implements PricingStrategy{

    @Override
    public boolean setPrice(Vehicle vehicle, Pricing pricing) {
        return false;
    }
}
