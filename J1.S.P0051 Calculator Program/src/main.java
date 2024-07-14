
import java.util.Scanner;
public class main {
    
    public static void Menu() {
        //Use loop to select option multiple times
        while(true) {
            //Step 1. Display a menu
            Calculator.menu();
            
            //Step 2. Ask users to select an option
            int options = Calculator.input();
            
            //Step 3. Perform functions based on the selected option
            switch(options) {
                //Normal calculator
                case 1: 
                    cls(); Calculator.normalCalculator(options);
                    break;                
                //Calculator BMI index
                case 2:
                    cls(); Calculator.BMICalculator(options);
                    break;
                //Exit the program
                case 3:
                    Calculator.exit(options);                  
            }  
            
            Scanner sc = new Scanner(System.in);
            System.out.print("\n Press 'Enter' key to continue . . .");
            sc.nextLine();            
            cls();   
        }
    }
    
    public static void cls() { //Clear console
        try {
            new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
        } catch(Exception e) {
            System.out.println(e);
        }
    }      
    
    public static void main(String[] args) {
        main.Menu();
    }    
}
