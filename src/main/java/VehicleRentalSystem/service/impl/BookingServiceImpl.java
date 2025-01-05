package VehicleRentalSystem.service.impl;

import VehicleRentalSystem.model.Booking;
import VehicleRentalSystem.model.Branch;
import VehicleRentalSystem.model.Vehicle;
import VehicleRentalSystem.repository.InMemoryBookingRepository;
import VehicleRentalSystem.service.BookingService;
import VehicleRentalSystem.service.BranchService;
import VehicleRentalSystem.service.VehicleService;
import VehicleRentalSystem.util.allocationStrategy.LowestPriceAllocationStrategy;
import VehicleRentalSystem.util.allocationStrategy.VehicleAllocationStrategy;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

public class BookingServiceImpl implements BookingService {

    VehicleAllocationStrategy vehicleAllocationStrategy;
    BranchService branchService;
    VehicleService vehicleService;
    InMemoryBookingRepository inMemoryBookingRepository;

    public BookingServiceImpl() {
        branchService = new BranchServiceImpl();
        vehicleService = new VehicleServiceImpl();
        inMemoryBookingRepository = InMemoryBookingRepository.getInstance();
    }


    @Override
    public Booking bookVehicle(String vehicleType, String startTime, String endTime) {

        // Get the VehicleAllocationStrategy ( can be read from configs too )
        vehicleAllocationStrategy = new LowestPriceAllocationStrategy();

        // Parse the start and end time from format "29-02-2020 10:00 AM"
        // Can be moved to DateTimeUtil class
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy hh:mm a");
        LocalDateTime startDateTime = LocalDateTime.parse(startTime, formatter);
        LocalDateTime endDateTime = LocalDateTime.parse(endTime, formatter);

        // Get list all the Vehicles of the given type for the given time period
        List<Vehicle> vehicles = vehicleService.getVehiclesByType(vehicleType)
                .stream()
                .filter(vehicle -> isVehicleAvailable(vehicle.getVehicleId(), startDateTime, endDateTime))
                .collect(Collectors.toList());

        if(vehicles.size() == 0) {
            System.out.println("No " + vehicleType + " available for the given time period");
            return null;
        }

        // Allocate the vehicle based on the strategy
        Vehicle vehicle = vehicleAllocationStrategy.allocateVehicle(vehicles);

        Booking booking = new Booking(vehicle, startDateTime, endDateTime);
        inMemoryBookingRepository.addBooking(booking);
        System.out.println(vehicle.getVehicleId() + " from " + vehicle.getBranch().getName() + " booked.");
        return booking;
    }

    @Override
    public void viewVehicleInventory(String startTime, String endTime) {

        // Parse the start and end time from format "29-02-2020 10:00 AM"
        // Can be moved to DateTimeUtil class
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy hh:mm a");
        LocalDateTime startDateTime = LocalDateTime.parse(startTime, formatter);
        LocalDateTime endDateTime = LocalDateTime.parse(endTime, formatter);

        // Get all the branches
        List<Branch> branches = branchService.getBranches();

        // Iterate over each branch and check the availability of each vehicle and print the details grouped by vehicle type
//        Branch: Vasanth Vihar
//        Sedan DL 01 MR 9310 Booked
//        Hatchback DL 01 MR 9312 Available
//        Branch: Cyber City
//        Sedan DL 01 MR 9311 Booked
        System.out.println();
        for(Branch branch : branches){
            System.out.println("Branch: " + branch.getName());
            List<Vehicle> vehicles = branch.getVehicles();
            vehicles.stream()
                    .sorted((v1, v2) -> v1.getVehicleType().compareTo(v2.getVehicleType()))
                    .forEach(vehicle -> {
                        if(isVehicleAvailable(vehicle.getVehicleId(), startDateTime, endDateTime)){
                            System.out.println(vehicle.getVehicleType() + " " + vehicle.getVehicleId() + " Available");
                        } else {
                            System.out.println(vehicle.getVehicleType() + " " + vehicle.getVehicleId() + " Booked");
                        }
                    });
        }
        System.out.println();
    }

    // Get the booking details for a vehicle for a given time period
    public boolean isVehicleAvailable(String vehicleId, LocalDateTime startTime, LocalDateTime endTime) {
        Booking b = inMemoryBookingRepository.getBookingByVehicleIdAndTime(vehicleId, startTime, endTime);
        return b == null;
    }
}
