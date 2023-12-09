
Entities :-

1. Vehicle
   1. vehicleType
   2. regNo
   3. color
2. ParkingLot
   1. parking_lot_id
   2. List<Floor>
3. Floor
   1. floor_no
   2. 1-N
   3. 1 Truck , 2 Bike , Car
   4. List<Parking Slot>
   5. List<Occupied Parking Slot>
4. ParkingSlot
   1. slot_no - 1-N
   2. VehicleType
   3. Status ( Free , Occupied)
5. Ticket
   1. Vehicle
   2. Parking Slot
   3. Status ( Entered , Parked , Unparked , Exited )
   4. Payment Status

ENUMs

1. VehicleType
2. ParkingSlotStatus
3. TicketStatus

Use Cases
1. create_parking_lot
2. park_vehicle
3. unpark_vehicle
4. display
5. exit
