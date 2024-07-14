
import java.util.Scanner;
public class Calculator {
    
    public static final Scanner sc = new Scanner(System.in);

    public static void menu() {
            System.out.print("\n +-------------------------------------------------------------------------+\n");
            System.out.println(" |                          Calculator Program                             |");
            System.out.println(" | 1. Normal Calculator                                                    |");
            System.out.println(" | 2. BMI Calculator                                                       |");
            System.out.println(" | 3. Exit                                                                 |");
            System.out.println(" +-------------------------------------------------------------------------+");            
            System.out.print("\n Please choose one option: ");            
    }
    
    //Check user input number limit
    public static int input() {
        Scanner sc = new Scanner(System.in);
        //Use loop until user input correctly
        while (true) {
            try {
                int result = Integer.parseInt(sc.nextLine().trim());
                if (result < 1 || result > 3) {
                    throw new NumberFormatException();
                }
                return result;
            } 
            //When user not input correctly
            catch (NumberFormatException e) {
                System.out.println(" Please input number in rage [1, 3]");
                System.out.print(" Enter again: ");
            }
        }
    }  
    
    //1. Normal Calculator
    public static void normalCalculator(int options) {  
        System.out.println("\n ----- Normal Calculator -----");
        double memory;
        System.out.print(" Enter number: ");
        memory = getInputDouble();
        
        //Use loop to calculate multiple times
        while(true) {
            System.out.print(" Enter operator: ");
            String operator = getInputOperator();   
            
            switch(operator) {
                case "+":
                    System.out.print(" Enter number: ");
                    double number = getInputDouble();
                    memory = memory + number;
                    System.out.println(" Memory: " + memory);
                    break;
                case "-":
                    System.out.print(" Enter number: ");
                    number = getInputDouble();
                    memory = memory - number;
                    System.out.println(" Memory: " + memory);
                    break;
                case "*":
                    System.out.print(" Enter number: ");
                    number = getInputDouble();
                    if(number == 0) {
                        memory = 0;
                    } else {
                        memory = memory * number;
                    }
                    System.out.println(" Memory: " + memory);                    
                    break;
                case "/":
                    System.out.print(" Enter number: ");
                    number = getInputDouble();
                    if(number != 0) {
                        memory = memory / number;
                    } else {
                        System.out.println(" Cannot divide by 0.");
                    }
                    System.out.println(" Memory: " + memory);
                    break;
                case "^":
                    System.out.print(" Enter number: ");
                    number = getInputDouble();
                    memory = Math.pow(memory, number);
                    System.out.println(" Memory: " + memory);
                    break;
                case "=":
                    System.out.println(" Result: " + memory);
                    return;
            }
        }
    }
    
    //2. BMI Calculator
    public static void BMICalculator(int options) {  
        System.out.println("\n ----- BMI Calculator -----");
        System.out.print(" Enter Weight(kg): ");
        double weight = getInputWeight();
        System.out.print(" Enter Height(cm): ");
        double height = getInputHeight();
        height = height / 100;
        double BMI = weight / (height*height);
        String status = "";
        System.out.format(" BMI Number: %.2f \n", BMI);
        //Check the BMI status
        if(BMI < 19) {
            status = " UNDER-STANDARD";
        } else if(BMI < 25 && BMI >= 19) {
            status = " STANDARD";
        } else if(BMI < 30 && BMI >= 25) {
            status = " OVERWEIGHT";
        } else if(BMI < 40 && BMI >= 30) {
            status = " FAT";
        } else if(BMI >= 40) {
            status = " VERY FAT - SHOULD LOSE WEIGHT IMMEDIATELY";            
        }
        System.out.println(status);
    }
    
    //3. Exit
    public static void exit(int options) {
        System.exit(0);
    }

    
    public static String getInputOperator() {
        //Use loop to request user input operator correctly
        while(true) {
            String result = sc.nextLine().trim();
            if(result.equals("+") || result.equals("-")
                    || result.equals("*") || result.equals("/")
                    || result.equals("^") || result.equals("=")) {
                return result;
            } else {
                System.out.println(" Please input (+, -, *, /, ^, =)");
            }
            System.out.print(" Enter operator: ");
        }
    } 
    public static double getInputDouble() {        
        //Use loop to request user input number correctly
        while(true) { 
            try {
                double result = Double.parseDouble(sc.nextLine());
                return result;
            } catch(NumberFormatException e) {
                System.out.println(" Number is Digit");
                System.out.print(" Enter number: ");
            }
        }
    } 
    public static int getInputWeight() {
        //Use loop to request user input BMI value correctly
        while(true) { 
            try {
                double result = Double.parseDouble(sc.nextLine());
                return (int) result;
            } 
            //When user enter the datatype not number
            catch(Exception e) {
                System.out.println(" BMI is Digit");
                System.out.print(" Enter Weight: ");
            }
        }        
    } 
    public static int getInputHeight() {
        //Use loop to request user input BMI value correctly
        while(true) { 
            try {
                double result = Double.parseDouble(sc.nextLine());
                return (int) result;
            } 
            //When user enter the datatype not number
            catch(Exception e) {
                System.out.println(" BMI is Digit");
                System.out.print(" Enter Weight: ");
            }
        }        
    }   
 
    
    public static void cls() { //Clear console
        try {
            new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
        } catch(Exception e) {
            System.out.println(e);
        }
    }        
}
