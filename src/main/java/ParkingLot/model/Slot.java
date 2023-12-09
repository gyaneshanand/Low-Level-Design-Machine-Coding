package ParkingLot.model;

import ParkingLot.constant.OccupanyStatus;
import ParkingLot.constant.VehicleType;

public class Slot {

    int slotNo;
    VehicleType vehicleType;
    OccupanyStatus occupanyStatus;
    Vehicle vehicle;
    int floorNo;

    public Slot(int slotNo, VehicleType vehicleType, int floorNo) {
        this.slotNo = slotNo;
        this.vehicleType = vehicleType;
        this.occupanyStatus = OccupanyStatus.FREE;
        this.vehicle = null;
        this.floorNo = floorNo;
    }

    public int getSlotNo() {
        return slotNo;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public OccupanyStatus getOccupanyStatus() {
        return occupanyStatus;
    }

    public void setOccupanyStatus(OccupanyStatus occupanyStatus) {
        this.occupanyStatus = occupanyStatus;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public int getFloor() {
        return floorNo;
    }
}
