package VehicleRentalSystem.repository;

import VehicleRentalSystem.constant.VehicleType;
import VehicleRentalSystem.model.Vehicle;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class InMemoryVehicleRepository {

    private static Map<String, Vehicle> vehicles;
    private static InMemoryVehicleRepository inMemoryVehicleRepository;

    private InMemoryVehicleRepository() {
        vehicles = new HashMap<>();
    }

    public static InMemoryVehicleRepository getInstance() {
        if (inMemoryVehicleRepository == null) {
            inMemoryVehicleRepository = new InMemoryVehicleRepository();
        }
        return inMemoryVehicleRepository;
    }

    public Vehicle addVehicle(Vehicle vehicle) {
        vehicles.put(vehicle.getVehicleId(), vehicle);
        return vehicle;
    }

    // Get vehicle by id
    public Vehicle getVehicle(String vehicleId) {
        return vehicles.get(vehicleId);
    }

    // Get List of all Vehicles
    public List<Vehicle> getAllVehicles() {
        return (List<Vehicle>) vehicles.values();
    }

    // Get List of all Vehicles of a given type
    public List<Vehicle> getVehiclesByType(VehicleType vehicleType) {
        return vehicles.values()
                .stream()
                .filter(vehicle -> vehicle.getVehicleType().equals(vehicleType))
                .collect(Collectors.toList());
    }

}
