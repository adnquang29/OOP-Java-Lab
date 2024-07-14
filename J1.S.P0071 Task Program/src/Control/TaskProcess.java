package Control;

import Model.Task;
import Model.TaskList;
import static Validate.CheckDuplicate.checkDuplicate;
import java.util.List; 

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * The TaskProcess class provides methods for adding, deleting, and retrieving tasks.
 */
public class TaskProcess extends TaskList {      

    /**
     * Adds a task to the list of tasks.
     * @param t the list of tasks
     * @param name the name of the task
     * @param typeid the type ID of the task
     * @param date the date of the task
     * @param planFrom the planned start time of the task
     * @param planTo the planned end time of the task
     * @param typeName the type name of the task
     * @param assignee the assignee of the task
     * @param reviewer the reviewer of the task
     * @return the type ID of the task
     * @throws Exception if an error occurs during task addition
     */
    public int addTask(List<Task> t, String name, int typeid, String date, 
    double planFrom, double planTo, String typeName, String assignee, String reviewer) throws Exception {       
        Task task = new Task();     
        
        // Set attributes of the task object
        task.setName(name); 
        task.setTypeid(typeid);
        task.setDate(date); 
        task.setFrom(planFrom);
        task.setTo(planTo); 
        task.setAssignee(assignee);
        task.setReviewer(reviewer);     

        boolean isDuplicate = checkDuplicate(t, task, name, date, assignee);
        // When task information exists in the list
        if(isDuplicate) {
            System.out.println(" Task already exists");
        } 
        // Add task information to the list 
        else {
            int counter = 0;
            // Use loop to find the max existed task ID
            for(int i = 0; i < t.size(); i++) {                
                Task existingTask = t.get(i);
                // When ID of current task is greater than the counter
                if(existingTask.getId() > counter) {
                    counter = existingTask.getId();
                }
            }
            // Set and increase new task ID than the max existed task ID
            task.setId(counter + 1);
            t.add(task);
            // Save the updated list to file
            saveToFile(t, "task_data.txt");
        }   
        return typeid; // return 0;
    }    
    
    /**
     * Deletes a task from the list of tasks.
     * @param t the list of tasks
     * @param id the ID of the task to be deleted
     * @throws Exception if an error occurs during task deletion
     */
    public void deleteTask(List<Task> t, int id) throws Exception {
        if(id >= 1 && id <= t.size()) {
            t.remove(id - 1);      
            saveToFile(t, "task_data.txt");
            System.out.println(" Successful");
        } else {
            System.out.println(" Task not found");
        }        
    }
    
    /**
     * Retrieves and displays all tasks from the list of tasks.
     * @param t the list of tasks
     * @throws Exception if an error occurs during task retrieval
     */
    public void getDataTasks(List<Task> t) throws Exception {
        if(t.isEmpty()) {
            System.out.println("\n Task not found.");
        } else {           
            System.out.println("\n ---------------------------------- Task ----------------------------------\n");
            System.out.format(" %-5s%-15s%-11s%-14s%-7s%-10s%-10s\n", 
                    "ID", "Name", "Task Type", "Date", "Time", "Assignee", "Reviewer");
            System.out.println(" --------------------------------------------------------------------------");
            // Use loop to display all tasks in the list
            for(int i = 0; i < t.size(); i++) {
                Task task = t.get(i);
                System.out.print(task.toString());
            }
        }        
    }  
    
    // File IO
    
    /**
     * Saves the list of tasks to a file.
     * @param t the list of tasks
     * @param filename the name of the file to save to
     */
    public void saveToFile(List<Task> t, String filename) {
        try(FileWriter writer = new FileWriter(filename)) {
            // Use loop to write objects list of data to a file
            for(Task task : t) {
                // Fetching variables and formatting to be written
                writer.write(task.getId() + "," + task.getName() + "," +
                        task.getTypeid() + "," + task.getDate() + "," +
                        task.getFrom() + "," + task.getTo() + "," +
                        task.getAssignee() + "," + task.getReviewer() + "\n");
            }            
            // System.out.println("Data saved to \n " + filename);
        } 
        // Handling IOException if file writing fails
        catch(IOException e) {
            // System.out.println("Error saving data to file: \n" + e.getMessage());
        }
    }

    /**
     * Loads tasks from a file into the list of tasks.
     * @param t the list of tasks
     * @param filename the name of the file to load from
     */
    public void loadFromFile(List<Task> t, String filename) {
        try(BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if(data.length >= 8) { 
                    // Extracting data to recreate objects
                    int id = Integer.parseInt(data[0]);
                    String name = data[1];
                    int typeid = Integer.parseInt(data[2]);
                    String date = data[3];
                    double from = Double.parseDouble(data[4]);
                    double to = Double.parseDouble(data[5]);
                    String assignee = data[6];
                    String reviewer = data[7];
                    // Adding recreated objects to a record
                    Task task = new Task(id, name, typeid, date, from, to, assignee, reviewer);
                    t.add(task);
                }
            }
            // System.out.println("Data loaded from \n" + filename);
        } 
        // Handling various exceptions that might occur during file reading
        catch(IOException | ArrayIndexOutOfBoundsException | NumberFormatException e) {
            // System.out.println("Error loading data from file: \n" + e.getMessage());
        }
    }   
}
