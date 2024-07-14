
import java.util.Scanner;
public class main {

    public static void Menu() {
        //Use loop to select option multiple times
        while(true) {
            //Step 1. Display a menu
            HandyExpense.menu();
            
            //Step 2. Ask users to select an option
            int options = HandyExpense.input();
            
            //Step 3. Perform function based on the selected option
            switch(options) {
                //Add an expense
                case 1: cls(); HandyExpense.addAnExpense(options);
                break;
                //Display all expensé
                case 2: cls(); HandyExpense.displayAllExpenses(options);
                break;
                //Delete an expense
                case 3: cls(); HandyExpense.deleteAnExpense(options);
                break;
                //Quit
                case 4: HandyExpense.quit(options);
            }
            
            Scanner sc = new Scanner(System.in);
            System.out.print("\n Press 'Enter' key to continue . . .");
            sc.nextLine();            
            cls(); //Clear console                     
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
        HandyExpense.loadDataFromFile("expense_data.txt");

        Menu();

        HandyExpense.saveDataToFile("expense_data.txt");
    }     
}
