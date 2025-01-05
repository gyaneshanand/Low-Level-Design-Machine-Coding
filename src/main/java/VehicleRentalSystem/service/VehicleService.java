package VehicleRentalSystem.service;

import VehicleRentalSystem.model.Vehicle;

import java.util.List;

public interface VehicleService {
    public Vehicle addVehicle(String vehicleId, String vehicleType, String branchName);
    public List<Vehicle> getVehiclesByType(String vehicleType);
}
