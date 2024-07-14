package Validate;

import java.util.Scanner;

/**
 * The InputValidate class provides methods for validating user input.
 */
public class InputValidate {

    /**
     * Validates and retrieves the user's choice within a specified range.
     * @return The user's choice.
     */
    public static int getInputChoice() {
        Scanner sc = new Scanner(System.in);
        // Use loop until user inputs correctly
        while (true) {
            try {
                int result = Integer.parseInt(sc.nextLine().trim());
                if (result < 1 || result > 5) {
                    throw new NumberFormatException();
                }
                return result;
            } catch (NumberFormatException e) {
                System.out.println(" Please input number in range [1, 5]");
                System.out.print(" Enter again: ");
            }
        }
    }    
    
    /**
     * Validates and retrieves an integer input from the user.
     * @return The integer input.
     */
    public static int getInputInt() {
        Scanner scanner = new Scanner(System.in);
        // Use loop to request user input correctly
        while(true) {
            try {
                int result = Integer.parseInt(scanner.nextLine());
                return result;
            } catch(Exception e) {
                System.out.print(" Enter number of countries to add: ");
            }
        }
    }   
    
    /**
     * Validates and retrieves a floating-point input from the user.
     * @return The floating-point input.
     */
    public static float getInputFloat() {
        Scanner scanner = new Scanner(System.in);
        // Use loop to request user input correctly
        while(true) {
            try {
                float result = Float.parseFloat(scanner.nextLine());
                if(result > 0) {
                    return result;
                } else {
                    System.out.print(" Enter again: ");
                }
            } catch(Exception e) {
                System.out.print(" Enter again: ");
            }
        }
    }    
    
    /**
     * Validates and retrieves a string input from the user.
     * @return The string input.
     */
    public static String getInputString() {
        Scanner scanner = new Scanner(System.in);
        String input;
        // Use loop to request user input correctly
        while(true) {
            input = scanner.nextLine().trim();
            if(input.isEmpty() || (input.matches(".*\\d+.*") || input.matches(".*[+\\-*/].*"))) {
                System.out.print(" Enter again: ");
            } else {
                return input;
            }
        }
    }       
}
