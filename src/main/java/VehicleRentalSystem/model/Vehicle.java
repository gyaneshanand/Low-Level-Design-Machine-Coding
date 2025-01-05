package VehicleRentalSystem.model;

import VehicleRentalSystem.constant.VehicleType;

public class Vehicle {
    private String vehicleId;
    private VehicleType vehicleType;
    private Branch branch;

    public Vehicle(String vehicleId, VehicleType vehicleType, Branch branch) {
        this.vehicleId = vehicleId;
        this.vehicleType = vehicleType;
        this.branch = branch;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }
}
