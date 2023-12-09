package ParkingLot.constant;

public enum VehicleType {
    CAR("CAR"),
    BIKE("BIKE"),
    TRUCK("TRUCK");

    String value;

    VehicleType(String type) {
        this.value = type;
    }

    public String getValue() {
        return value;
    }
}
