package VehicleRentalSystem.repository;

import VehicleRentalSystem.model.Booking;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class InMemoryBookingRepository {

    private static InMemoryBookingRepository inMemoryBookingRepository;
    // There are multiple ways/data structures in which bookings can be stored
    // For simplicity, we are using a Map to store bookings which booking ID as the key
    // Other ways were to store bookings with vehicle ID as the key which would have helped in fetching all bookings for a vehicle efficiently
    private static Map<Integer, Booking> bookings;

    private InMemoryBookingRepository() {
        bookings = new HashMap<>();
    }

    public static InMemoryBookingRepository getInstance() {
        if (inMemoryBookingRepository == null) {
            inMemoryBookingRepository = new InMemoryBookingRepository();
        }
        return inMemoryBookingRepository;
    }

    public Booking addBooking(Booking booking) {
        bookings.put(booking.getId(), booking);
        return booking;
    }

    // Get List of all the Bookings for a vehicle
    public List<Booking> getBookingsForVehicle(String vehicleId) {
        return bookings.values()
                .stream()
                .filter(booking -> booking.getVehicle().getVehicleId().equals(vehicleId))
                .collect(Collectors.toList());
    }

    // Get the booking details for a vehicle where either startTime is between the booking's startTime and endTime
    // or endTime is between the booking's startTime and endTime
    public Booking getBookingByVehicleIdAndTime(String vehicleId, LocalDateTime start, LocalDateTime end) {

        return bookings.values()
                .stream()
                .filter(b -> b.getVehicle().getVehicleId().equals(vehicleId) &&
                        ((b.getStartTimeStamp().compareTo(start) <= 0 && b.getEndTimeStamp().compareTo(start) >= 0) ||
                                (b.getStartTimeStamp().compareTo(end) <= 0 && b.getEndTimeStamp().compareTo(end) >= 0)))
                .findFirst()
                .orElse(null);
    }
}
