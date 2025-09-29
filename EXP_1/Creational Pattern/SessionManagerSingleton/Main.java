import sessionmanager.AuthenticationManager;
import sessionmanager.Utils;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AuthenticationManager authManager = AuthenticationManager.getInstance();
        boolean running = true;

        Utils.logInfo("Authentication Manager started.");

        while(running) {
            System.out.println("\n=== Authentication Menu ===");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Logout");
            System.out.println("4. Check Active Session");
            System.out.println("5. Exit");

            String choice = Utils.readLine("Enter choice: ", scanner);

            try {
                switch (choice) {
                    case "1" -> {
                        String username = Utils.readLine("Enter username: ", scanner);
                        String password = Utils.readLine("Enter password: ", scanner);
                        authManager.registerUser(username, password);
                        System.out.println("User registered successfully!");
                    }
                    case "2" -> {
                        String username = Utils.readLine("Enter username: ", scanner);
                        String password = Utils.readLine("Enter password: ", scanner);
                        if(authManager.loginUser(username, password)) {
                            System.out.println("Login successful!");
                        } else {
                            System.out.println("Login failed! Invalid credentials.");
                        }
                    }
                    case "3" -> {
                        authManager.logout();
                        System.out.println("Logged out successfully.");
                    }
                    case "4" -> {
                        authManager.getActiveSession()
                                .ifPresentOrElse(session ->
                                        System.out.println("Active session for: " + session.getUser().getUsername() +
                                                " since " + session.getLoginTime()),
                                        () -> System.out.println("No active session."));
                    }
                    case "5" -> {
                        running = false;
                        Utils.logInfo("Exiting Authentication Manager.");
                    }
                    default -> System.out.println("Invalid choice. Try again.");
                }
            } catch (Exception e) {
                Utils.logWarning("Exception occurred: " + e.getMessage());
                System.out.println("Error: " + e.getMessage());
            }
        }
        scanner.close();
    }
}
