package ParkingLot.model;

import ParkingLot.constant.TicketStatus;

import java.time.LocalDateTime;
import java.util.Date;

public class Ticket {

    String ticketId;
    Slot slot;
    Vehicle vehicle;
    TicketStatus ticketStatus;
    LocalDateTime entryTime;
    LocalDateTime exitTime;

    public Ticket(String ticketId, Slot slot, Vehicle vehicle, LocalDateTime entryTime) {
        this.ticketId = ticketId;
        this.slot = slot;
        this.vehicle = vehicle;
        this.ticketStatus = null;
        entryTime = entryTime;
        exitTime = null;
    }

    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    public Slot getSlot() {
        return slot;
    }

    public void setSlot(Slot slot) {
        this.slot = slot;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public TicketStatus getTicketStatus() {
        return ticketStatus;
    }

    public void setTicketStatus(TicketStatus ticketStatus) {
        this.ticketStatus = ticketStatus;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(LocalDateTime entryTime) {
        this.entryTime = entryTime;
    }

    public LocalDateTime getExitTime() {
        return exitTime;
    }

    public void setExitTime(LocalDateTime exitTime) {
        this.exitTime = exitTime;
    }
}
