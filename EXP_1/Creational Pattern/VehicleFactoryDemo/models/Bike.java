
package models;
public class Bike extends Vehicle {
    public Bike(String brand, int maxSpeed, String fuelType) {
        super(brand, maxSpeed, fuelType);
    }

    @Override
    public void drive() {
        System.out.println("Riding a bike at " + maxSpeed + " km/h.");
    }
}