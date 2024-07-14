
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
public class HandyExpense {
    
    public static ExpenseList expenseList = new ExpenseList();
    public static Scanner sc = new Scanner(System.in);    
    
    public static void menu() {
        System.out.print("\n +");
        for(int i = 0; i < 73; i++) {
            System.out.print("-");
        }
        System.out.println("+");
            System.out.println(" |                          Handy Expense program                          |");
            System.out.printf(" |%-73s|\n", "  1. Add an expense");
            System.out.printf(" |%-73s|\n", "  2. Display all expenses");
            System.out.printf(" |%-73s|\n", "  3. Delete an expense");
            System.out.printf(" |%-73s|\n", "  4. Quit");
        System.out.print(" +");
        for(int i = 0; i < 73; i++) {
            System.out.print("-");
        }
        System.out.println("+");            
            System.out.print("\n Select an option: ");           
    }    

    //Check user input number limit
    public static int input() {
        Scanner sc = new Scanner(System.in);
        //Use loop until user input correctly
        while (true) {
            try {
                int result = Integer.parseInt(sc.nextLine().trim());
                if (result < 1 || result > 4) {
                    throw new NumberFormatException();
                }
                return result;
            } 
            //When user not input correctly
            catch (NumberFormatException e) {
                System.out.println(" Please input number in rage [1, 4]");
                System.out.print(" Enter again: ");
            }
        }
    }     

    //Add an expense
    public static void addAnExpense(int options) {
        //List<Expense> list = new ArrayList<Expense>();
        System.out.println("\n ------------------ Add an expense ------------------");
        System.out.print(" Enter Date: ");
        String date = ExpenseList.getInputDate();
        System.out.print(" Enter Amount: ");
        double amount = ExpenseList.getInputAmount();
        System.out.print(" Enter Content: ");
        String content = ExpenseList.getInputContent();
        
        expenseList.addExpense(expenseList.list, date, amount, content);
    }

    //Display all expenses
    public static void displayAllExpenses(int options) {
        //List<Expense> list = new ArrayList<Expense>();
        expenseList.displayAll(expenseList.list);
    }

    //Delete an expense
    public static void deleteAnExpense(int options) {
        System.out.println("\n ----------------- Delete an expense ----------------");
        System.out.print(" Enter ID: ");
        int id = ExpenseList.getInputID();
        
        Expense deleteExpense = new Expense(); 
        deleteExpense.setId(id);
        expenseList.deleteExpense(expenseList.list, deleteExpense);
    }
    
    //Exit
    public static void quit(int options) {
        System.exit(0);
    }
    
    //File IO
    public static void saveDataToFile(String filename) {
        expenseList.saveToFile(filename);
    }
    public static void loadDataFromFile(String filename) {
        expenseList.loadFromFile(filename);
    }     
}
