package Validate;

import java.util.Scanner;

/**
 * The InputValidate class provides methods for validating user input.
 */
public class InputValidate {
    
    /**
     * Validates user input for selecting a choice within a specified range.
     * @return The validated user input choice.
     */
    public static int getInputChoice() {
        Scanner sc = new Scanner(System.in);
        // Use loop until user input correctly
        while (true) {
            try {
                int result = Integer.parseInt(sc.nextLine().trim());
                if (result < 1 || result > 4) {
                    throw new NumberFormatException();
                }
                return result;
            } catch (NumberFormatException e) {
                System.out.println(" Please input number in range [1, 4]");
                System.out.print(" Enter again: ");
            }
        }
    }   

    /**
     * Validates user input for a phone number.
     * @return The validated phone number input.
     */
    public static String getInputPhone() { 
        Scanner sc = new Scanner(System.in);
        String VALID_PHONE = "[(]?[0-9]{3}[)]?[-. ]?[0-9]{3}[-. ]?[0-9]{4}"
                + "|[0-9]{3}[-][0-9]{3}[-][0-9]{4}[ a-z0-9]+";
        // Use loop until user input value correctly
        while(true) {
            String result = sc.nextLine();
            if(result.matches(VALID_PHONE)) {
                return result;
            }
            System.out.println(" Please input Phone following the specified formats:\n"
                    + " • 1234567890\n"
                    + " • 123-456-7890 \n"
                    + " • 123-456-7890 x1234\n"
                    + " • 123-456-7890 ext1234\n"
                    + " • (123)-456-7890\n"
                    + " • 123.456.7890\n"
                    + " • 123 456 7890");
            System.out.print(" Enter Phone: ");
        }
    } 
    
    /**
     * Validates user input for an integer value.
     * @return The validated integer input.
     */
    public static int getInputInt() {   
        Scanner sc = new Scanner(System.in);
        // Use loop until user input value correctly
        while(true) {
            try {
                int result = Integer.parseInt(sc.nextLine());
                return result;
            } catch(NumberFormatException e) {
                System.out.println(" ID must be a digit.");
                System.out.print(" Enter ID: ");
            }
        }
    }      
    
    /**
     * Validates user input for a string value.
     * @return The validated string input.
     */
    public static String getInputString() {
        Scanner sc = new Scanner(System.in);
        String input;
        // Use loop until user input value correctly
        while(true) {
            input = sc.nextLine().trim();
            // Require enter again when enter incorrect format
            if(input.isEmpty() || (input.matches(".*\\d+.*") || input.matches(".*[+\\-*/].*"))) {
                System.out.print(" Enter again: ");
            } else {
                return input;
            }
        }
    }     
}
