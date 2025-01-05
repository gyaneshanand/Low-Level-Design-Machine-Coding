package VehicleRentalSystem.model;

import VehicleRentalSystem.constant.PricingUnit;
import VehicleRentalSystem.constant.VehicleType;
import VehicleRentalSystem.dto.Pricing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Branch {
    private int id;
    private String name;
    private String location;
    private List<Vehicle> vehicles;
    private Map<VehicleType, List<Pricing>> pricing;

    public Branch(String name) {
        this.id = (int) (Math.random() * 1000000); // random 6 digit number
        this.name = name;
        vehicles = new ArrayList<>();
        pricing = new HashMap<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public Map<VehicleType, List<Pricing>> getPricing() {
        return pricing;
    }
}
