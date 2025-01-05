package VehicleRentalSystem.model;

import java.time.LocalDateTime;

public class Booking {

    private int id;
    private Vehicle vehicle;
    private LocalDateTime startTimeStamp;
    private LocalDateTime endTimeStamp;
    private String status;

    public Booking(Vehicle vehicle, LocalDateTime startTimeStamp, LocalDateTime endTimeStamp) {
        this.id = (int) (Math.random() * 1000000); // random 6 digit number for now
        this.vehicle = vehicle;
        this.startTimeStamp = startTimeStamp;
        this.endTimeStamp = endTimeStamp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public LocalDateTime getStartTimeStamp() {
        return startTimeStamp;
    }

    public void setStartTimeStamp(LocalDateTime startTimeStamp) {
        this.startTimeStamp = startTimeStamp;
    }

    public LocalDateTime getEndTimeStamp() {
        return endTimeStamp;
    }

    public void setEndTimeStamp(LocalDateTime endTimeStamp) {
        this.endTimeStamp = endTimeStamp;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
