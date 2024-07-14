import Validate.InputValidate;
import View.ContactProgram;
import java.util.Scanner;

/**
 * The main class contains the entry point of the contact program and manages the user interface.
 */
public class Main {

    /**
     * Display the menu and ask users to select an option
     * Then perform function based on the selected option.
     * The program is to manage the data of contact, including
     * ID, name, group, address and phone number.
     */
    public static void Menu() {
        // Use loop to select option multiple times
        while(true) {
            // Step 1. Display a menu
            ContactProgram.menu();
            
            // Step 2. Ask users to select an option
            int options = InputValidate.getInputChoice();
            
            // Step 3. Perform function based on the selected option.
            switch(options) {
                // Add contact
                case 1: cls(); ContactProgram.addContact(options);
                    break;
                // Display the contact
                case 2: cls(); ContactProgram.displayAll(options);
                    break;
                // Delete the contact
                case 3: cls(); ContactProgram.deleteContact(options);
                    break;
                // Exit the program
                case 4: ContactProgram.exit(options);
            }

            Scanner sc = new Scanner(System.in);
            System.out.print("\n Press 'Enter' key to continue . . .");
            sc.nextLine();            
            cls(); // Clear console            
        }        
    }
    
    /**
     * Clears the console screen.
     */
    public static void cls() { // Clear console
        try {
            new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
        } catch(Exception e) {
            System.out.println(e);
        }
    }    
    
    /**
     * The entry point of the contact program.
     * @param args The command line arguments.
     */
    public static void main(String[] args) {
        ContactProgram.loadDataFromFile("contact_data.txt");
        
        Main.Menu();
        
        ContactProgram.saveDataToFile("contact_data.txt");
    }
}
