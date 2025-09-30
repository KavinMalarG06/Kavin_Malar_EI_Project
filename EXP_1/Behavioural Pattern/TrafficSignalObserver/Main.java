import core.TrafficSignal;
import core.TrafficSignalState;
import observers.PedestrianObserver;
import observers.TrafficPoliceObserver;
import observers.VehicleObserver;
import utils.InputValidator;
import utils.LoggerUtil;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        LoggerUtil.getLogger().info("Starting Traffic Signal Monitoring System...");

        TrafficSignal signal = new TrafficSignal();
        signal.attach(new TrafficPoliceObserver());
        signal.attach(new PedestrianObserver());
        signal.attach(new VehicleObserver());

        Scanner scanner = new Scanner(System.in);
        boolean exitRequested = false;

        while (!exitRequested) {
            System.out.println("\n=== Traffic Signal Menu ===");
            System.out.println("1. Change Signal to RED");
            System.out.println("2. Change Signal to YELLOW");
            System.out.println("3. Change Signal to GREEN");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");

            String input = scanner.nextLine();
            try {
                int choice = InputValidator.validateMenuChoice(input, 1, 4);

                switch (choice) {
                    case 1 -> signal.changeSignal(TrafficSignalState.RED);
                    case 2 -> signal.changeSignal(TrafficSignalState.YELLOW);
                    case 3 -> signal.changeSignal(TrafficSignalState.GREEN);
                    case 4 -> exitRequested = true;
                }
            } catch (Exception e) {
                LoggerUtil.getLogger().warning("Invalid input: " + e.getMessage());
            }
        }

        LoggerUtil.getLogger().info("Shutting down Traffic Signal Monitoring System.");
        scanner.close();
    }
}
