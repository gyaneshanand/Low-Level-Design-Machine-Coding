package ParkingLot.util;

import ParkingLot.constant.OccupanyStatus;
import ParkingLot.constant.VehicleType;
import ParkingLot.model.Floor;
import ParkingLot.model.ParkingLot;
import ParkingLot.model.Slot;

import java.util.List;

public class LowestCountAvalabilityProvider implements AvalabilityProviderStrategy {

    @Override
    public Slot getAvailableSlot(ParkingLot parkingLot, VehicleType vehicleType) {
        List<Floor> floorList = parkingLot.getFloorList();
        for(Floor floor : floorList){
            for (Slot slot : floor.getSlotList()){
                if (slot.getOccupanyStatus()== OccupanyStatus.FREE && (slot.getVehicleType().compareTo(vehicleType)==0))
                    return slot;
            }
        }
        return null;
    }
}
