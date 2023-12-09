package ParkingLot.service;

import ParkingLot.constant.VehicleType;
import ParkingLot.model.Vehicle;
import ParkingLot.repository.InMemoryCommonRepository;

public class VehicleService {

    InMemoryCommonRepository inMemoryCommonRepository;

    public VehicleService() {
        this.inMemoryCommonRepository = InMemoryCommonRepository.getInstance();
    }

    public Vehicle createVehicle(VehicleType vehicleType, String regNo, String color){
        Vehicle vehicle = new Vehicle(regNo, color, vehicleType);
        inMemoryCommonRepository.getVehicles().add(vehicle);
        return vehicle;
    }
}
