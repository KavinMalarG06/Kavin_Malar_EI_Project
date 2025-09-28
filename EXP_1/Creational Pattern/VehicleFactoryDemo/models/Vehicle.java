package models;

public abstract class Vehicle {
    protected String brand;
    protected int maxSpeed;
    protected String fuelType;

    public Vehicle(String brand, int maxSpeed, String fuelType) {
        this.brand = brand;
        this.maxSpeed = maxSpeed;
        this.fuelType = fuelType;
    }

    public abstract void drive();

    public void refuel() {
        System.out.println(brand + " is refueling with " + fuelType);
    }

    public void displayInfo() {
        System.out.println("Vehicle: " + brand + ", Max Speed: " + maxSpeed + " km/h, Fuel: " + fuelType);
    }
}
