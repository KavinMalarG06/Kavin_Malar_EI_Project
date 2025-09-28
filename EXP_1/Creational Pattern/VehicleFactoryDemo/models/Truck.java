package models;
public class Truck extends Vehicle {
    public Truck(String brand, int maxSpeed, String fuelType) {
        super(brand, maxSpeed, fuelType);
    }

    @Override
    public void drive() {
        System.out.println("Driving a heavy truck at " + maxSpeed + " km/h.");
    }
}