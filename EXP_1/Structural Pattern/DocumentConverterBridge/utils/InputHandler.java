package utils;

import java.util.Scanner;

public class InputHandler {
    private static final Scanner sc = new Scanner(System.in);

    public static String getNonEmptyString(String prompt) {
        String input = "";
        while (input.isBlank()) {
            System.out.print(prompt);
            input = sc.nextLine().trim();
            if (input.isEmpty()) {
                LoggerUtil.logInfo("Input cannot be empty. Please try again.");
            }
        }
        return input;
    }

    public static String getMultiLineInput(String prompt, String endSignal) {
        System.out.println(prompt + " (end with '" + endSignal + "'):");
        StringBuilder contentBuilder = new StringBuilder();
        while (true) {
            String line = sc.nextLine();
            if (line.trim().equalsIgnoreCase(endSignal)) break;
            contentBuilder.append(line).append("\n");
        }
        return contentBuilder.toString();
    }

    public static String getFormatChoice(String prompt, String[] validChoices) {
        String choice = "";
        while (true) {
            System.out.print(prompt + " " + String.join("/", validChoices) + ": ");
            choice = sc.nextLine().trim().toLowerCase();
            for (String valid : validChoices) {
                if (choice.equals(valid)) return choice;
            }
            LoggerUtil.logInfo("Invalid choice. Please enter a valid format.");
        }
    }
}
