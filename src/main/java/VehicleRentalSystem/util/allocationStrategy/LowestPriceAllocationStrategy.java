package VehicleRentalSystem.util.allocationStrategy;

import VehicleRentalSystem.constant.VehicleType;
import VehicleRentalSystem.model.Branch;
import VehicleRentalSystem.model.Vehicle;
import VehicleRentalSystem.service.BookingService;
import VehicleRentalSystem.service.impl.BookingServiceImpl;
import javafx.util.Pair;

import java.util.List;

public class LowestPriceAllocationStrategy implements VehicleAllocationStrategy {

    public LowestPriceAllocationStrategy() {
    }


    @Override
    public Vehicle allocateVehicle(List<Vehicle> vehicles) {
        VehicleType vehicleType = vehicles.get(0).getVehicleType();

        // Get the vehicle which has minimum price
        vehicles.sort(
                (v1, v2) -> (int) (v1.getBranch().getPricing().get(vehicleType).get(0).getPrice()
                        - v2.getBranch().getPricing().get(vehicleType).get(0).getPrice())
        );
        return vehicles.get(0);
    }
}
