package VehicleRentalSystem;

import VehicleRentalSystem.service.BookingService;
import VehicleRentalSystem.service.BranchService;
import VehicleRentalSystem.service.VehicleService;
import VehicleRentalSystem.service.impl.BookingServiceImpl;
import VehicleRentalSystem.service.impl.BranchServiceImpl;
import VehicleRentalSystem.service.impl.VehicleServiceImpl;

public class VehicleRentalSystem {

    public static void main(String[] args) {
        System.out.println("Vehicle Rental System");

        BranchService branchService = new BranchServiceImpl();
        VehicleService vehicleService = new VehicleServiceImpl();
        BookingService bookingService = new BookingServiceImpl();

        branchService.addBranch("Vasanth Vihar");
        branchService.addBranch("Cyber City");

        branchService.allocatePrice("Vasanth Vihar", "Sedan", 100);
        branchService.allocatePrice("Vasanth Vihar", "Hatchback", 80);
        branchService.allocatePrice("Cyber City", "Sedan", 200);
        branchService.allocatePrice("Cyber City", "Hatchback", 50);

        vehicleService.addVehicle("DL 01 MR 9310", "Sedan", "Vasanth Vihar");
        vehicleService.addVehicle("DL 01 MR 9311", "Sedan", "Cyber City");
        vehicleService.addVehicle("DL 01 MR 9312", "Hatchback", "Cyber City");

        bookingService.viewVehicleInventory("29-02-2020 10:00 AM", "29-02-2020 01:00 PM");
        bookingService.bookVehicle("Sedan", "29-02-2020 10:00 AM", "29-02-2020 01:00 PM");
        bookingService.viewVehicleInventory("29-02-2020 10:00 AM", "29-02-2020 01:00 PM");
        bookingService.bookVehicle("Sedan", "29-02-2020 02:00 PM", "29-02-2020 03:00 PM");
        bookingService.bookVehicle("Sedan", "29-02-2020 02:00 PM", "29-02-2020 03:00 PM");
        bookingService.bookVehicle("Sedan", "29-02-2020 02:00 PM", "29-02-2020 03:00 PM");
    }
}
