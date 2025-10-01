import java.util.Scanner;
import utils.MenuHandler;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Vehicle Factory Application ===");

        Scanner scanner = new Scanner(System.in);

        try {
            MenuHandler menuHandler = new MenuHandler(scanner);
            menuHandler.showMenu();
        } 
        catch (Exception e) {
            System.out.println("Unexpected error occurred: " + e.getMessage());
            e.printStackTrace();
        } 
        finally {
            if (scanner != null) {
                scanner.close();
            }
            System.out.println("=== Vehicle Factory Application terminated ===");
        }
    }
}
