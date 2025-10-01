package utils;

import java.util.Scanner;
import enums.VehicleCategory;
import models.Vehicle;
import factory.AdvancedVehicleFactory;

public class MenuHandler {

    private boolean continueRunning = true;
    private final Scanner scanner;

    public MenuHandler(Scanner scanner) {
        this.scanner = scanner;
    }

    public void showMenu() {
        while (continueRunning) {
            try {
                System.out.println("\n=== Vehicle Factory Menu ===");
                System.out.println("1. Create Passenger Vehicle");
                System.out.println("2. Create Commercial Vehicle");
                System.out.println("3. Exit");
                System.out.print("Enter choice: ");

                String choiceInput = scanner.nextLine().trim();

                if (!isInteger(choiceInput)) {
                    System.out.println("Invalid input type. Please enter a number for menu choice.");
                    continue;
                }

                int choice = Integer.parseInt(choiceInput);

                switch(choice) {
                    case 1: createVehicle(VehicleCategory.PASSENGER); break;
                    case 2: createVehicle(VehicleCategory.COMMERCIAL); break;
                    case 3:
                        System.out.println("Exiting Vehicle Factory Application.");
                        continueRunning = false; break;
                    default: System.out.println("Invalid menu choice: " + choice);
                }

            } 
            catch (Exception e) {
                System.out.println("Unexpected error occurred: " + e.getMessage());
            }
        }
    }

    private void createVehicle(VehicleCategory category) {
        try {
            System.out.print("Enter vehicle type (Car, Bike, Truck): ");
            String type = scanner.nextLine().trim();
            if(!isAlpha(type)) {
                System.out.println("Invalid input type for vehicle type. Only letters allowed.");
                return;
            }

            System.out.print("Enter brand: ");
            String brand = scanner.nextLine().trim();
            if(!isAlphaNumeric(brand)) {
                System.out.println("Invalid input type for brand. Only letters/numbers allowed.");
                return;
            }

            System.out.print("Enter max speed (km/h): ");
            String speedInput = scanner.nextLine().trim();
            if(!isInteger(speedInput)) {
                System.out.println("Invalid input type for max speed. Must be an integer.");
                return;
            }
            int maxSpeed = Integer.parseInt(speedInput);

            System.out.print("Enter fuel type (Petrol/Diesel/Electric): ");
            String fuelType = scanner.nextLine().trim();
            if(!isAlpha(fuelType)) {
                System.out.println("Invalid input type for fuel type. Only letters allowed.");
                return;
            }

            Vehicle vehicle = AdvancedVehicleFactory.createVehicle(category, type, brand, maxSpeed, fuelType);

            if(vehicle != null) {
                System.out.println("Vehicle created successfully: " + type + " [" + category + "]");
                vehicle.displayInfo();
                vehicle.drive();
                vehicle.refuel();
            } else {
                System.out.println("Failed to create vehicle. Check type/category combination.");
            }

        } catch (Exception e) {
            System.out.println("Error during vehicle creation: " + e.getMessage());
        }
    }

    private boolean isInteger(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch(NumberFormatException e) {
            return false;
        }
    }

    private boolean isAlpha(String input) {
        return input.matches("[a-zA-Z]+");
    }

    private boolean isAlphaNumeric(String input) {
        return input.matches("[a-zA-Z0-9]+");
    }
}
