package ParkingLot.repository;

import ParkingLot.model.Ticket;
import ParkingLot.model.Vehicle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class InMemoryCommonRepository {

    private static InMemoryCommonRepository inMemoryCommonRepository;
    private HashMap<String, Ticket> ticketHashMap;
    private List<Vehicle> vehicles;

    private InMemoryCommonRepository() {
        this.ticketHashMap = new HashMap<>();
        this.vehicles = new ArrayList<>();
    }

    public static InMemoryCommonRepository getInstance() {
        if(inMemoryCommonRepository == null) {
            inMemoryCommonRepository = new InMemoryCommonRepository();
        }
        return inMemoryCommonRepository;
    }

    public HashMap<String, Ticket> getTicketHashMap() {
        return ticketHashMap;
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }
}
