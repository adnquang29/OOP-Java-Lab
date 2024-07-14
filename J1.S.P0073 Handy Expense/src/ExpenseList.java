
import java.util.List; 
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Date;
import java.text.SimpleDateFormat;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ExpenseList extends Expense {

    List<Expense> list;

    public ExpenseList() {
        list = new ArrayList<Expense>();
    }

    public ExpenseList(List<Expense> list, int id, String date, double amount, String content) {
        super(id, date, amount, content);
        this.list = list;
    }

    public boolean addExpense(List<Expense> list, String date, double amount, String content) {
        boolean isDuplicate = false;
        Expense expense = new Expense();
        
        //Set attributes of the expense object
        expense.setDate(date);
        expense.setQuantity(amount);
        expense.setContent(content);
        
        //Use loop to find the expense in the list
        for(int i = 0; i < list.size(); i++) {
            Expense duplicate = list.get(i);
            //When the input match the expense in the list
            if(expense.getContent().equals(duplicate.getContent())) {
                isDuplicate = true;
                break;
            }
        }
        //When expense information exists in the list
        if(isDuplicate) {
            System.out.println(" Expense already exists");
            return false;
        } 
        //Add expense information to the list 
        else {
            int max = 0;
            //Use loop to find the max existed expense ID
            for(int i = 0; i < list.size(); i++) {
                Expense existingExpense = list.get(i);
                //When ID of current expense is greater than the max
                if(existingExpense.getId() > max) {
                    max = existingExpense.getId();
                }
            }
            //Set and increase new expense ID than the max existed expense ID
            expense.setId(max + 1);
            list.add(expense);
            //Save the updated list to file
            saveToFile("expense_data.txt");
            return true;
        }
    }

    public void displayAll(List<Expense> list) {
        if(list.isEmpty()) {
            System.out.println("\n Expense not exist");
        } else {
            double totalAmount = 0;
            System.out.println("\n ----------------- Display all expenses ----------------\n");
            System.out.format(" %-6s %-14s %-10s %-21s\n",
                    "ID", "Date", "Amount", "Content");
            System.out.println(" -------------------------------------------------------");
            //Use loop to display all expense in the list
            for(int i = 0; i < list.size(); i++) {
                Expense expense = list.get(i);
                totalAmount += expense.getQuantity();
                System.out.print(expense.toString());
            }
            System.out.printf(" %-19s %-7s %-10.0f\n", "", "Total:", totalAmount);            
        }
    }
    
    public boolean deleteExpense(List<Expense> list, Expense exp) {
        boolean deletionResult = list.remove(exp);
        //When expense not being deleted in the list
        if(!deletionResult) {
            for(int i = 0; i < list.size(); i++) {
                Expense e = list.get(i);
                //When expense existed in the list 
                if(e.getId() == exp.getId()) {
                    list.remove(e);
                    deletionResult = true;
                    break;
                }
            }
        }
        //Warning when the expense being deleted
        if(deletionResult) {
            saveToFile("expense_data.txt");
            System.out.println(" Successful");
        } 
        //When expense not found from user's input
        else {
            System.out.println(" Delete an expense fail");
        }
        return deletionResult;
    }  
    
    public static String getInputDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
        Scanner sc = new Scanner(System.in); 
        sdf.setLenient(false);
        Date date;  
        //Use loop until user input value correctly 
        while(true) {
            try {
                date = sdf.parse(sc.nextLine());
                Date now = new Date();
                //When date value is larger than current date
                if(date.after(now)) {
                    continue;
                } else {
                    break;
                }                
            } 
            //When date is not valid
            catch(Exception e) {
                System.out.println(" Date must in format dd-MMM-yyyy");
                System.out.print(" Enter Date: ");
            }          
        } 
        return sdf.format(date);
    } 

    public static double getInputAmount() {   
        Scanner sc = new Scanner(System.in);
        //Use loop until user input value correctly
        while(true) {
            try {
                double result = Double.parseDouble(sc.nextLine());
                //When amount value smaller than 0
                if(result < 0) {
                    System.out.println(" Amount must be larger or equals to 0");
                    System.out.print(" Enter Amount: ");
                } else {
                    return result;
                }
            } 
            //When amount value is not valid
            catch(NumberFormatException e) {
                System.out.println(" Amount is Digit");
                System.out.print(" Enter Amount: ");
            }
        }
    } 
    
    public static String getInputContent() {
        Scanner sc = new Scanner(System.in);
        String input;
        //Use loop until user input value correctly
        while(true) {
            input = sc.nextLine().trim();
            //Require enter again when enter incorrect format
            if(input.isEmpty() || (input.matches(".*\\d+.*") || input.matches(".*[+\\-*/].*"))) {
                System.out.println(" Content must be valid");
                System.out.print(" Enter Content: ");
            } else {
                return input;
            }
        }
    }      
    
    public static int getInputID() {   
        Scanner sc = new Scanner(System.in);
        //Use loop until user input value correctly
        while(true) {
            try {
                int result = Integer.parseInt(sc.nextLine());
                return result;
            } 
            //When amount value is not valid
            catch(NumberFormatException e) {
                System.out.println(" ID is Digit");
                System.out.print(" Enter ID: ");
            }
        }
    }    
    
    //File IO
    public void saveToFile(String filename) {
        try(FileWriter writer = new FileWriter(filename)) {
            //Use loop to write objects list of data to a file
            for(Expense expense : list) {
                //Fetching variables and formatting to be written
                writer.write(expense.getId() + "," + expense.getDate() + "," +
                expense.getQuantity() + "," + expense.getContent() + "\n");
            }
            //System.out.println(" Data saved to \n " + filename);
        } 
        //Handling IOException if file writing fails
        catch(IOException e) {            
            //System.out.println(" Error saving data to file: \n " + e.getMessage());
        }
    }
    public void loadFromFile(String filename) {
        try(BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            //Use loop to read each line of data in file
            while((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if(data.length >= 4) {
                    //Extracting data to recreate objects
                    int id = Integer.parseInt(data[0]);
                    String date = data[1];
                    double amount = Double.parseDouble(data[2]);
                    String content = data[3];
                    Expense expense = new Expense(id, date, amount, content);
                    //Adding recreated objects to a record
                    list.add(expense);
                }
            }           
            //System.out.println(" Data loaded from \n" + filename);
        } 
        //Handling various exceptions that might occur during file reading
        catch(IOException | ArrayIndexOutOfBoundsException | NumberFormatException e) {            
            //System.out.println(" Error loading data from file: \n" + e.getMessage());
        }
    }    
}
