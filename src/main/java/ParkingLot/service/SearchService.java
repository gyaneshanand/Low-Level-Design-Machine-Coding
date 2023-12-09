package ParkingLot.service;

import ParkingLot.constant.VehicleType;
import ParkingLot.model.ParkingLot;

import java.util.List;

public interface SearchService {

    public void searchFreeCount(ParkingLot parkingLot, VehicleType vehicleType);
    public void searchFreeSlots(ParkingLot parkingLot, VehicleType vehicleType);
    public void searchOccupiedSlots(ParkingLot parkingLot, VehicleType vehicleType);
}
