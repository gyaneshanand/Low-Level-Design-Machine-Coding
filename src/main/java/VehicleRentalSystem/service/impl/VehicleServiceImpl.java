package VehicleRentalSystem.service.impl;

import VehicleRentalSystem.constant.VehicleType;
import VehicleRentalSystem.model.Branch;
import VehicleRentalSystem.model.Vehicle;
import VehicleRentalSystem.repository.InMemoryVehicleRepository;
import VehicleRentalSystem.service.BranchService;
import VehicleRentalSystem.service.VehicleService;

import java.util.List;

public class VehicleServiceImpl implements VehicleService {

    private InMemoryVehicleRepository vehicleRepository;
    private BranchService branchService;

    public VehicleServiceImpl() {
        vehicleRepository = InMemoryVehicleRepository.getInstance();
        branchService = new BranchServiceImpl();
    }

    @Override
    public Vehicle addVehicle(String vehicleId, String vehicleType, String branchName) {
        Branch branch = branchService.getBranchByName(branchName);
        if (branch == null) {
            System.out.println("Branch not found: " + branchName);
            return null;
        }
        Vehicle vehicle = new Vehicle(vehicleId, VehicleType.valueOf(vehicleType), branch);
        vehicleRepository.addVehicle(vehicle);
        branch.getVehicles().add(vehicle);
        System.out.println("Vehicle added: " + vehicleId);
        return null;
    }

    // Get vehicle list by Vehicle Type
    public List<Vehicle> getVehiclesByType(String vehicleType) {
        return vehicleRepository.getVehiclesByType(VehicleType.valueOf(vehicleType));
    }
}
