package ParkingLot.service;

import ParkingLot.constant.TicketStatus;
import ParkingLot.exception.InvalidTicketException;
import ParkingLot.model.ParkingLot;
import ParkingLot.model.Slot;
import ParkingLot.model.Ticket;
import ParkingLot.model.Vehicle;
import ParkingLot.repository.InMemoryCommonRepository;

import java.time.LocalDateTime;

public class TicketingService {

    InMemoryCommonRepository inMemoryCommonRepository;

    public TicketingService() {
        this.inMemoryCommonRepository = InMemoryCommonRepository.getInstance();
    }

    public Ticket createTicket(ParkingLot parkingLot, Slot slot, Vehicle vehicle){

        String ticketId = parkingLot.getParkingLotId()+ "_" + String.valueOf(slot.getFloor()) + "_" +String.valueOf(slot.getSlotNo());

        Ticket ticket = new Ticket(ticketId, slot, vehicle, LocalDateTime.now());
        ticket.setTicketStatus(TicketStatus.PARKED);
        inMemoryCommonRepository.getTicketHashMap().putIfAbsent(ticket.getTicketId(), ticket);
        return ticket;
    }

    public Ticket getTicketById(String ticketId){
        return inMemoryCommonRepository.getTicketHashMap().getOrDefault(ticketId, null);
    }

    public void updateTicketStatus(Ticket ticket, TicketStatus ticketStatus){
        ticket.setTicketStatus(ticketStatus);
    }

}
