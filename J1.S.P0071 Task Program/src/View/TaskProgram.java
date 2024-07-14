package View;

import Control.TaskProcess;
import Model.Task;
import Validate.InputValidate;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * The TaskProgram class provides methods to interact with the task management system.
 */
public class TaskProgram {

    public static List<Task> list = new ArrayList<Task>();
    public static TaskProcess taskProcess = new TaskProcess();
    public static Scanner sc = new Scanner(System.in); 

    /**
     * Displays the main menu of the task program.
     */
    public static void displayMenu() {
        System.out.print("\n +");
        for(int i = 0; i < 72; i++) {
            System.out.print("-");
        }
        System.out.println("+");
        System.out.println(" |                              Task Program                              |");                                 
        System.out.printf(" |%-72s|\n", "  1. Add Task");
        System.out.printf(" |%-72s|\n", "  2. Delete Task");
        System.out.printf(" |%-72s|\n", "  3. Display Task");
        System.out.printf(" |%-72s|\n", "  4. Exit");
        System.out.print(" +");
        for(int i = 0; i < 72; i++) {
            System.out.print("-");
        }
        System.out.println("+");            
        System.out.print("\n Select an option: ");           
    }  

    /**
     * Adds a new task to the list.
     * @param options the selected option
     * @throws Exception if an error occurs during task addition
     */
    public static void addTask(int options) throws Exception {
        System.out.println("\n ------------ Add Task ------------");
        System.out.print(" Requirement Name: ");
        String name = InputValidate.getInputString();
        System.out.print(" Task Type: ");
        int typeid = InputValidate.getInputType();
        System.out.print(" Date: ");
        String date = InputValidate.getInputDate();
        System.out.print(" From: ");
        double from = InputValidate.getInputFrom();
        System.out.print(" To: ");
        double to = InputValidate.getInputTo(from);
        System.out.print(" Assignee: ");
        String assignee = InputValidate.getInputString();
        System.out.print(" Reviewer: ");
        String reviewer = InputValidate.getInputString();

        taskProcess.addTask(list, name, typeid, date, from, to, name, assignee, reviewer);
    }

    /**
     * Deletes a task from the list.
     * @param options the selected option
     * @throws Exception if an error occurs during task deletion
     */
    public static void deleteTask(int options) throws Exception {
        System.out.println("\n ------------ Del Task ------------");
        System.out.print(" ID: ");
        int id = InputValidate.getInputInt();
        taskProcess.deleteTask(list, id);
    }

    /**
     * Displays all tasks in the list.
     * @param options the selected option
     * @throws Exception if an error occurs during task display
     */
    public static void displayTask(int options) throws Exception {       
        taskProcess.getDataTasks(list);
    }

    /**
     * Exits the program.
     * @param options the selected option
     */
    public static void exit(int options) {
        System.exit(0);
    }      

    // File IO

    /**
     * Saves the task list to a file.
     * @param filename the name of the file
     */
    public static void saveDataToFile(String filename) {
        taskProcess.saveToFile(list, filename);
    }

    /**
     * Loads task data from a file.
     * @param filename the name of the file
     */
    public static void loadDataFromFile(String filename) {
        taskProcess.loadFromFile(list, filename);
    }    
}
