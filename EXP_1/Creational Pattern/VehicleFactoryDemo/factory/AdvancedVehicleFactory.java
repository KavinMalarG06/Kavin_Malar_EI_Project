package factory;

import models.*;
import enums.VehicleCategory;


public class AdvancedVehicleFactory {

    public static Vehicle createVehicle(VehicleCategory category, String type, String brand, int maxSpeed, String fuelType) {
        switch(category) {
            case PASSENGER:
                if(type.equalsIgnoreCase("Car")) return new Car(brand, maxSpeed, fuelType);
                if(type.equalsIgnoreCase("Bike")) return new Bike(brand, maxSpeed, fuelType);
                break;
            case COMMERCIAL:
                if(type.equalsIgnoreCase("Truck")) return new Truck(brand, maxSpeed, fuelType);
                break;
            default:
                System.out.println("Unknown category/type combination.");
        }
        return null;
    }
}
