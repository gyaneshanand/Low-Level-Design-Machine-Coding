package ParkingLot.util;

import ParkingLot.constant.VehicleType;
import ParkingLot.model.ParkingLot;
import ParkingLot.model.Slot;

public interface AvalabilityProviderStrategy {

    public Slot getAvailableSlot(ParkingLot parkingLot ,VehicleType vehicleType);
}
