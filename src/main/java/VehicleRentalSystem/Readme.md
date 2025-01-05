Entities

1. Branch
   1. Name
   2. List<Vehicle>
   3. Map<VehicleType, List<Pricing>>
2. Vehicle
   1. Id
   2. VehicleType
   3. Branch
3. VehicleType ( ENUM ) -> Sedan, Hatchback, SUV, etc.
4. Booking
   1. StartTime
   2. EndTime
   3. Vehicle
   4. Id
   5. OtherMetadata
5. Pricing
   1. Rate
   2. Unit ( ENUM ) -> Hourly, Daily, Weekly, Monthly, etc.

6. VehicleAllocationStrategy ( Interface )
   1. LowestPriceAllocationStrategy ( Implementation )
7. PricingStrategy
    1. PerBranchPerVehicleTypePricingStrategy ( Implementation )