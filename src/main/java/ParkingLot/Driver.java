package ParkingLot;

import ParkingLot.service.ParkingLotService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Driver {

    public static void main(String[] args) throws IOException {

        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);

        ParkingLotService parkingLotService = new ParkingLotService();
        String parkingLotCreation = parkingLotService.createParkingLot("PR1234", 2 , 4);
        System.out.println(parkingLotCreation);

        String input = br.readLine();
        while (!input.equalsIgnoreCase("exit")){
            String action = input.split(" ")[0];
            if(action.equals("park_vehicle")){
                String data[] = input.split(" ");
                String parking = parkingLotService.parkVehicle(data[1], data[2], data[3]);
                System.out.println(parking);
            } else if (action.equals("unpark_vehicle")) {
                String data[] = input.split(" ");
                String unparking = parkingLotService.unParkVehicle(data[1]);
                System.out.println(unparking);
            }
            else if(action.equals("display")){
                String data[] = input.split(" ");
                parkingLotService.search(data[1], data[2]);
            }
            else {
                System.out.println("Invalid Input");
            }
            input = br.readLine();
        }
    }
}
