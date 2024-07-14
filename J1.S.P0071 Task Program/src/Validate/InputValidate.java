package Validate;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * The InputValidate class provides methods for validating user input.
 */
public class InputValidate {

    /**
     * Validates and returns the user's choice for menu options.
     * @return the validated user choice
     */
    public static int getInputChoice() {
        Scanner sc = new Scanner(System.in);
        // Use loop until user input is correct
        while (true) {
            try {
                int result = Integer.parseInt(sc.nextLine().trim());
                if (result < 1 || result > 4) {
                    throw new NumberFormatException();
                }
                return result;
            } catch (NumberFormatException e) {
                System.out.println(" Please input a number in the range [1, 4]");
                System.out.print(" Enter again: ");
            }
        }
    }       

    /**
     * Validates and returns an integer input.
     * @return the validated integer input
     */
    public static int getInputInt() {
        Scanner sc = new Scanner(System.in);
        // Use loop until user input is correct
        while(true) {
            try {
                int result = Integer.parseInt(sc.nextLine());
                return result;
            } catch(NumberFormatException e) {
                System.out.println(" Input must be a number");
                System.out.print(" Enter number: ");
            }
        }
    } 

    /**
     * Validates and returns a string input.
     * @return the validated string input
     */
    public static String getInputString() {
        Scanner sc = new Scanner(System.in);
        String input;
        // Use loop until user input is correct
        while(true) {
            input = sc.nextLine().trim();
            // Require input again when entered incorrectly
            if(input.isEmpty() || (input.matches(".*\\d+.*") || input.matches(".*[+\\-*/].*"))) {
                System.out.print(" Enter again: ");
            } else {
                return input;
            }
        }
    } 

    /**
     * Validates and returns the type of task input.
     * @return the validated task type input
     */
    public static int getInputType() {
        Scanner sc = new Scanner(System.in);
        // Use loop until user input is correct
        while (true) {
            try {
                int input = Integer.parseInt(sc.nextLine().trim());
                if(input < 1 || input > 4) {
                    throw new NumberFormatException();
                }
                return input;
            } catch(NumberFormatException e) {
                System.out.println(" Type must be in the range 1-4");
                System.out.println(" 1: Code\n 2: Test\n 3: Design\n 4: Review");
                System.out.print(" Enter again: ");
            }
        }
    }    

    /**
     * Validates and returns a date input in the format dd-MM-yyyy.
     * @return the validated date input
     */
    public static String getInputDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Scanner sc = new Scanner(System.in); 
        sdf.setLenient(false);
        Date date;  
        // Use loop until user input is correct 
        while(true) {
            try {
                date = sdf.parse(sc.nextLine());
                Date now = new Date();
                // When date value is after the current date
                if(date.after(now)) {
                    continue;
                } else {
                    break;
                }                
            } catch(Exception e) {
                System.out.println(" Date must be in the format dd-MM-yyyy");
                System.out.print(" Enter again: ");
            }          
        } 
        return sdf.format(date);
    }

    /**
     * Validates and returns the 'from' time input.
     * @return the validated 'from' time input
     */
    public static double getInputFrom() {
        Scanner sc = new Scanner(System.in);
        double from = 0;
        // Use loop until user input is correct 
        while(true) {
            try {
                from = Double.parseDouble(sc.nextLine());
                if(from >= 8 && from <= 17.5) {
                    if(from % 0.5 == 0) {
                        break;
                    }
                } 
                // When input is an invalid time range
                else {
                    System.out.println(" Time must be from 8.0 to 17.5");
                    System.out.print(" Enter again: ");
                }
            } catch(Exception e) {
                System.out.println(" Invalid input");
                System.out.print(" Enter again: ");
            }
        }
        return from;
    }

    /**
     * Validates and returns the 'to' time input.
     * @param from the 'from' time value
     * @return the validated 'to' time input
     */
    public static double getInputTo(double from) {
        Scanner sc = new Scanner(System.in);
        double to = 0;
        boolean validInput = false;
        // Use loop until user input is correct 
        while(!validInput) {
            try {
                to = Double.parseDouble(sc.nextLine());
                // When input 'to' is larger than 'from'
                if(to >= 8 && to <= 17.5 && to % 0.5 == 0) {
                    if(to > from) {
                        validInput = true;
                    } else {                       
                        System.out.println(" To must be larger than from");
                        System.out.print(" Enter again: ");
                    }
                } 
                // When input is an invalid time range
                else {
                    System.out.println(" Time must be from 8.0 to 17.5");
                    System.out.print(" Enter again: ");
                }
            } catch(Exception e) {
                System.out.println(" Invalid input");
                System.out.print(" Enter again: ");
            }
        }
        return to;
    }  
}
