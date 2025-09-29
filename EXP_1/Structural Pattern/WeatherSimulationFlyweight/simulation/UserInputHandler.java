package simulation;

import java.util.Scanner;
import utils.LoggerUtil;

public class UserInputHandler {
    private final Scanner scanner = new Scanner(System.in);

    public String getUserChoice() {
        System.out.println("\n=== Weather Simulation Menu ===");
        System.out.println("1. Add Cumulus Cloud");
        System.out.println("2. Add Cirrus Cloud");
        System.out.println("3. Add Stratus Cloud");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");

        String input = scanner.nextLine().trim();
        LoggerUtil.getLogger().info(() -> "User entered: " + input);
        return input;
    }
}
