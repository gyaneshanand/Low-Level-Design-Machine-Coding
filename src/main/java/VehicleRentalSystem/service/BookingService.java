package VehicleRentalSystem.service;

import VehicleRentalSystem.model.Booking;

public interface BookingService {
    public Booking bookVehicle(String vehicleType, String startTime, String endTime);
    public void viewVehicleInventory(String startTime, String endTime);
}
