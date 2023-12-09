Entities

1. Branch
   1. Name
   2. List<Vehicle>
   3. Map<VehicleType, List<Pricing>>
2. Vehicle
   1. Id
   2. VehicleType
   3. Branch
3. VehicleType ( ENUM )
4. Booking
   1. TimeSlot
   2. Vehicle
   3. Id
   4. OtherMetadata
5. TimeSlot
   1. StartTime
   2. EndTime
6. Pricing
   1. Rate
   2. Unit ( ENUM )

7. VehicleAllocationStrategy ( Interface )
   1. LowestPriceAllocationStrategy ( Implementation )