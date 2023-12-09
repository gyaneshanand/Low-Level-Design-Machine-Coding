package ParkingLot.service;

import ParkingLot.constant.OccupanyStatus;
import ParkingLot.constant.TicketStatus;
import ParkingLot.constant.VehicleType;
import ParkingLot.exception.InvalidTicketException;
import ParkingLot.model.*;
import ParkingLot.repository.InMemoryCommonRepository;
import ParkingLot.util.LowestCountAvalabilityProvider;

public class ParkingLotService {

    InMemoryCommonRepository inMemoryCommonRepository;
    ParkingLot parkingLot;
    SearchService searchService;

    public ParkingLotService() {
        this.inMemoryCommonRepository = InMemoryCommonRepository.getInstance();
        this.searchService = new FloorwiseSearchServiceImpl();
    }

    public String createParkingLot(String parkingLotId, int numFloors, int numSpotsPerFloor) {
        ParkingLot parkingLot = new ParkingLot(parkingLotId, numFloors);
        for (int i = 1; i <= numFloors; i++) {
            parkingLot.getFloorList().add(new Floor(i, numSpotsPerFloor));
        }
        this.parkingLot = parkingLot; // Assuming only 1 Parking Lot RIght now. Else we can use InMemoryCommonRepository
        return "Created parking lot with " + numFloors + "floors and " + numSpotsPerFloor + " slots per floor";
    }

    public String parkVehicle(String type, String regNo, String color){
        String message = "";
        try{

            VehicleType vehicleType = VehicleType.valueOf(type);

            ParkingService parkingService = new ParkingService(new LowestCountAvalabilityProvider(), parkingLot);
            Ticket parkingTicket = parkingService.parkVehicleAtSlot(vehicleType, regNo, color);

            // Return message
            message += "Parked vehicle. Ticket ID: "+ parkingTicket.getTicketId();
        }catch (Exception e){
            message += e.getMessage();
        }
        return message;
    }

    public String unParkVehicle(String ticketId){
        String message = "";
        try {
            ParkingService parkingService = new ParkingService(new LowestCountAvalabilityProvider(), parkingLot);

            Ticket parkingTicket = parkingService.UnParkVehicle(ticketId);
            Vehicle vehicle = parkingTicket.getVehicle();

            message = "Unparked vehicle with Registration Number: " + vehicle.getRegNo() +" and Color: " + vehicle.getColor();
        }
        catch (Exception e){
            message = e.getMessage();
        }
        return message;
    }

    public void search(String action, String type){
        VehicleType vehicleType = VehicleType.valueOf(type);
        if(action.equals("free_count")){
            searchService.searchFreeCount(parkingLot, vehicleType);
        } else if (action.equals("free_slots")) {
            searchService.searchFreeSlots(parkingLot, vehicleType);
        } else if (action.equals("occupied_slots")) {
            searchService.searchOccupiedSlots(parkingLot, vehicleType);
        }else {
            System.out.println("Invalid Search Action");
        }
    }
}
