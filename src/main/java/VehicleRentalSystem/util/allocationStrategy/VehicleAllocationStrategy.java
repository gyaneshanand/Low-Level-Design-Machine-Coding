package VehicleRentalSystem.util.allocationStrategy;

import VehicleRentalSystem.model.Vehicle;

import java.util.List;

public interface VehicleAllocationStrategy {
    public Vehicle allocateVehicle(List<Vehicle> vehicles);
}
