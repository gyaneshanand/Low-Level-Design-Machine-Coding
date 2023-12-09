package ParkingLot.service;

import ParkingLot.constant.OccupanyStatus;
import ParkingLot.constant.TicketStatus;
import ParkingLot.constant.VehicleType;
import ParkingLot.exception.InvalidTicketException;
import ParkingLot.exception.NoSlotFoundException;
import ParkingLot.model.ParkingLot;
import ParkingLot.model.Slot;
import ParkingLot.model.Ticket;
import ParkingLot.model.Vehicle;
import ParkingLot.util.AvalabilityProviderStrategy;

public class ParkingService {

    VehicleService vehicleService;
    AvalabilityProviderStrategy avalabilityProviderStrategy;
    ParkingLot parkingLot;
    TicketingService ticketingService;

    public ParkingService(AvalabilityProviderStrategy avalabilityProviderStrategy, ParkingLot parkingLot) {
        this.avalabilityProviderStrategy = avalabilityProviderStrategy;
        this.parkingLot = parkingLot;
        this.vehicleService = new VehicleService();
        this.ticketingService = new TicketingService();
    }

    public Ticket parkVehicleAtSlot(VehicleType vehicleType, String regNo, String color) throws Exception{
        Vehicle vehicle = vehicleService.createVehicle(vehicleType, regNo, color);

        // get Parking slot
        Slot availableSlot = avalabilityProviderStrategy.getAvailableSlot(parkingLot, vehicleType);
        if(availableSlot==null)
            throw new NoSlotFoundException("Parking Lot Full");

        // Park Vehicle
        availableSlot.setOccupanyStatus(OccupanyStatus.OCCUPIED);
        availableSlot.setVehicle(vehicle);

        // Get Ticket
        Ticket ticket = ticketingService.createTicket(parkingLot, availableSlot, availableSlot.getVehicle());

        return ticket;
    }

    public Ticket UnParkVehicle(String ticketId){

        Ticket ticket = ticketingService.getTicketById(ticketId);

        if(ticket==null || ticket.getTicketStatus().equals(TicketStatus.UNPARKED))
            throw new InvalidTicketException("Invalid Ticket");

        ticketingService.updateTicketStatus(ticket, TicketStatus.UNPARKED);
        ticket.getSlot().setVehicle(null);
        ticket.getSlot().setOccupanyStatus(OccupanyStatus.FREE);

        return ticket;
    }
}
