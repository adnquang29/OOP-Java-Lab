import Validate.InputValidate;
import View.TaskProgram;
import java.util.Scanner;

/**
 * The main class for the task program.
 */
public class main {

    /**
     * Display the menu and ask users to select an option
     * Then perform function based on the selected option.
     * The program is to manage the task information, including
     * task ID, name, type, date, time, assignee and reviewer.
     * 
     * @throws Exception if an error occurs during menu handling.
     */
    public static void Menu() throws Exception {
        // Use loop to select option multiple times
        while(true) {
            // Step 1. Display a menu
            TaskProgram.displayMenu();

            // Step 2. Ask users to select an option
            int options = InputValidate.getInputChoice();

            // Step 3. Perform function based on the selected option
            switch(options) {
                // Add Task
                case 1: cls(); TaskProgram.addTask(options);
                    break;
                // Delete Task
                case 2: cls(); TaskProgram.deleteTask(options);
                    break;
                // Display Task
                case 3: cls(); TaskProgram.displayTask(options);
                    break;
                // Exit
                case 4: TaskProgram.exit(options);
                    break;
            }

            Scanner sc = new Scanner(System.in);
            System.out.print("\n Press 'Enter' key to continue . . .");
            sc.nextLine();
            cls(); // Clear console
        }
    }

    /**
     * Clears the console.
     */
    public static void cls() { // Clear console
        try {
            new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
        } catch(Exception e) {
            System.out.println(e);
        }
    }

    /**
     * The main method.
     * @param args command line arguments
     * @throws Exception if an error occurs during program execution
     */
    public static void main(String[] args) throws Exception {
        TaskProgram.loadDataFromFile("task_data.txt");

        Menu();

        TaskProgram.saveDataToFile("task_data.txt");
    }
}
