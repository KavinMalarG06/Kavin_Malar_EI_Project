package utils;

import exceptions.InvalidInputException;

public class InputValidator {
    public static int validateMenuChoice(String input, int min, int max) {
        try {
            int choice = Integer.parseInt(input);
            if (choice < min || choice > max) {
                throw new InvalidInputException("Choice out of range.");
            }
            return choice;
        } catch (NumberFormatException e) {
            throw new InvalidInputException("Invalid number entered.");
        }
    }
}
