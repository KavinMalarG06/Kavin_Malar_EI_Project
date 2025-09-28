package models;
public class Car extends Vehicle {
    public Car(String brand, int maxSpeed, String fuelType) {
        super(brand, maxSpeed, fuelType);
    }

    @Override
    public void drive() {
        System.out.println("Driving a car at " + maxSpeed + " km/h.");
    }
}