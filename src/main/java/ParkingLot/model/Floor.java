package ParkingLot.model;

import ParkingLot.constant.VehicleType;

import java.util.ArrayList;
import java.util.List;

public class Floor {

    int floorNo;
    int floorCapacity;
    List<Slot> slotList;

    public Floor(int floorNo, int floorCapacity) {
        this.floorNo = floorNo;
        this.floorCapacity = floorCapacity;
        this.slotList = new ArrayList<>();
        createSlots(floorNo);
    }

    private void createSlots(int floorNo){
        for (int i = 1; i <= this.floorCapacity; i++) {
            if(i<=1){
                this.slotList.add(new Slot(i, VehicleType.TRUCK, floorNo));
            }
            else if (i<=3){
                this.slotList.add(new Slot(i, VehicleType.BIKE, floorNo));
            }
            else {
                this.slotList.add(new Slot(i, VehicleType.CAR, floorNo));
            }
        }
    }

    public int getFloorNo() {
        return floorNo;
    }

    public int getFloorCapacity() {
        return floorCapacity;
    }

    public List<Slot> getSlotList() {
        return slotList;
    }
}
