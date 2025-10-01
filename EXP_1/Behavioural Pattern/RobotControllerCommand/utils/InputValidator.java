package utils;
import java.util.Scanner;

public class InputValidator {
    private static final Scanner scanner = new Scanner(System.in);

    public static int getValidatedInt(String prompt, int min, int max) {
        int input;
        while (true) {
            try {
                System.out.print(prompt);
                input = Integer.parseInt(scanner.nextLine());
                if (input < min || input > max) {
                    LoggerUtil.logError("Input out of range. Try again.");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                LoggerUtil.logError("Invalid input. Enter a number.");
            }
        }
        return input;
    }
}
