import Validate.InputValidate;
import View.ManageEastAsiaCountries;
import java.util.Scanner;

/**
 * The main class contains the entry point of the program and manages the user interface.
 */
public class main {

    /**
     * Display the menu and ask users to select an option
     * Then perform function based on the selected option.
     * The program is to manage the geographic, specially
     * 11 countries in Southeast Asia, including ID, name,
     * total area and terrain.
     */
    public static void Menu() {
        while(true) {
            //Step 1. Display a menu
            ManageEastAsiaCountries.menu();

            //Step 2. Ask users to select an option
            int options = InputValidate.getInputChoice();

            //Step 3. Perform function based on the selected option
            switch(options) {
                case 1:
                    cls(); ManageEastAsiaCountries.addCountryInformation(options);
                    break;
                case 2:
                    cls(); ManageEastAsiaCountries.getRecentlyEnteredInformation(options);
                    break;
                case 3:
                    cls(); ManageEastAsiaCountries.searchInformationByName(options);
                    break;
                case 4:
                    cls(); ManageEastAsiaCountries.sortInformaionByAscendingOrder(options);
                    break;
                case 5:
                    ManageEastAsiaCountries.exit(options);
            }

            Scanner scanner = new Scanner(System.in);
            System.out.print("\n Press 'Enter' key to continue . . .");
            scanner.nextLine();            
            cls(); //Clear console
        }
    }
    
    /**
     * Clears the console.
     */
    public static void cls() { //Clear console
        try {
            new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
        } catch(Exception e) {
            System.out.println(e);
        }
    }
    
    /**
     * The entry point of the program.
     * @param args The command line arguments.
     */
    public static void main(String[] args) {
        main.Menu();
    }
}
