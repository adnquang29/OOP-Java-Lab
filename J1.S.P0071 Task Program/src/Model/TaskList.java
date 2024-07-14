package Model;

import java.util.ArrayList;
import java.util.List;

/**
 * The TaskList class represents a list of tasks.
 */
public class TaskList extends Task {
    
    List<Task> t;
    String typeName;

    /**
     * Constructs an empty TaskList.
     */
    public TaskList() {  
        t = new ArrayList<Task>();
    }

    /**
     * Constructs a TaskList with specified parameters.
     * @param t the list of tasks
     * @param id the ID of the task
     * @param name the name of the task
     * @param typeid the type ID of the task
     * @param date the date of the task
     * @param planFrom the planned start time of the task
     * @param planTo the planned end time of the task
     * @param typeName the type name of the task
     * @param assignee the assignee of the task
     * @param reviewer the reviewer of the task
     */
    public TaskList(List<Task> t, int id, String name, int typeid, String date, 
    double planFrom, double planTo, String typeName, String assignee, String reviewer) {
        super(id, name, typeid, date, planFrom, planTo, assignee, reviewer);
        this.t = t;
        this.typeName = typeName;
    }

    /**
     * Gets the type name of the task list.
     * @return the type name of the task list
     */
    public String getTypeName() {
        return typeName;
    }     
}
