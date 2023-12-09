package ParkingLot.model;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {

    String parkingLotId;
    int parkingLotCapacity;
    List<Floor> floorList;

    public ParkingLot(String parkingLotId, int parkingLotCapacity) {
        this.parkingLotId = parkingLotId;
        this.parkingLotCapacity = parkingLotCapacity;
        this.floorList = new ArrayList<>();
    }

    public String getParkingLotId() {
        return parkingLotId;
    }

    public int getParkingLotCapacity() {
        return parkingLotCapacity;
    }

    public List<Floor> getFloorList() {
        return floorList;
    }
}
