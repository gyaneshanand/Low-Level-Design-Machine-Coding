package VehicleRentalSystem.dto;

import VehicleRentalSystem.constant.PricingUnit;

public class Pricing {
    private Float price;
    private PricingUnit unit;

    public Pricing(Float price) {
        this.price = price;
        this.unit = PricingUnit.HOURLY; // Default unit is hourly
    }

    public Pricing(Float price, PricingUnit unit) {
        this.price = price;
        this.unit = unit;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public PricingUnit getUnit() {
        return unit;
    }

    public void setUnit(PricingUnit unit) {
        this.unit = unit;
    }
}
