package Validate;

import Model.Task;
import java.util.List;

/**
 * The CheckDuplicate class provides methods for checking duplicate tasks.
 */
public class CheckDuplicate {
    
    /**
     * Checks if a task with the same name, date, or assignee already exists in the list.
     * @param t the list of tasks to check for duplicates
     * @param task the task to be checked for duplicates
     * @param name the name of the task
     * @param date the date of the task
     * @param assignee the assignee of the task
     * @return true if a duplicate task is found, otherwise false
     */
    public static boolean checkDuplicate(List<Task> t, Task task, String name, String date, String assignee) {
        boolean isDuplicate = false;
        // Use loop to find the existing task in the list
        for(int i = 0; i < t.size(); i++) {
            Task duplicate = t.get(i);
            // When the input matches the task in the list
            if(task.getName().equals(duplicate.getName())
                || task.getDate().equals(duplicate.getDate())
                || task.getAssignee().equals(duplicate.getAssignee())) {
                isDuplicate = true;
                break;
            }           
        } 
        return isDuplicate;
    }
}
