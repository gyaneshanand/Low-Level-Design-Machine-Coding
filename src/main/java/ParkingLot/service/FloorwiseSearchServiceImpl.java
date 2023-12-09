package ParkingLot.service;

import ParkingLot.constant.OccupanyStatus;
import ParkingLot.constant.VehicleType;
import ParkingLot.model.Floor;
import ParkingLot.model.ParkingLot;
import ParkingLot.model.Slot;

public class FloorwiseSearchServiceImpl implements SearchService{
    @Override
    public void searchFreeCount(ParkingLot parkingLot, VehicleType vehicleType) {
        for(Floor floor : parkingLot.getFloorList()){
            int freeCount = 0;
            for(Slot slot : floor.getSlotList()){
                if(slot.getOccupanyStatus()== OccupanyStatus.FREE && slot.getVehicleType()==vehicleType)
                    freeCount++;
            }
            System.out.println("No. of free slots for "+ vehicleType.getValue() +" on Floor "+ floor.getFloorNo() +": " + freeCount);
        }
    }

    @Override
    public void searchFreeSlots(ParkingLot parkingLot, VehicleType vehicleType) {
        for(Floor floor : parkingLot.getFloorList()){
            String message = "Free slots for " + vehicleType.getValue() +" on Floor "+ floor.getFloorNo() +": ";
            for(Slot slot : floor.getSlotList()){
                if(slot.getOccupanyStatus()== OccupanyStatus.FREE && slot.getVehicleType()==vehicleType)
                    message+=slot.getSlotNo() + ",";
            }
            System.out.println(message);
        }
    }

    @Override
    public void searchOccupiedSlots(ParkingLot parkingLot, VehicleType vehicleType) {
        for(Floor floor : parkingLot.getFloorList()){
            String message = "Occupied slots for " + vehicleType.getValue() +" on Floor "+ floor.getFloorNo() +": ";
            for(Slot slot : floor.getSlotList()){
                if(slot.getOccupanyStatus()== OccupanyStatus.OCCUPIED && slot.getVehicleType()==vehicleType)
                    message+=slot.getSlotNo() + ",";
            }
            System.out.println(message);
        }
    }
}
