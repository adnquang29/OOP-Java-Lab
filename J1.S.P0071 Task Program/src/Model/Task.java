package Model;

/**
 * The Task class represents a task.
 */
public class Task {
    
    private int id;
    private String name;
    private int typeid;
    private String date;
    private double from;
    private double to;
    private String assignee;
    private String reviewer;

    public Task() {
        id = 0;
        name = "";
        typeid = 0;
        date = "";
        from = 0;
        to = 0;
        assignee = "";
        reviewer = "";
    }

    public Task(int id, String name, int typeid, String date, double from, double to, String assignee, String reviewer) {
        this.id = id;
        this.name = name;
        this.typeid = typeid;
        this.date = date;
        this.from = from;
        this.to = to;
        this.assignee = assignee;
        this.reviewer = reviewer;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getTypeid() {
        return typeid;
    }

    public String getDate() {
        return date;
    }

    public double getFrom() {
        return from;
    }

    public double getTo() {
        return to;
    }

    public String getAssignee() {
        return assignee;
    }

    public String getReviewer() {
        return reviewer;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTypeid(int typeid) {
        this.typeid = typeid;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setFrom(double from) {
        this.from = from;
    }

    public void setTo(double to) {
        this.to = to;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    public void setReviewer(String reviewer) {
        this.reviewer = reviewer;
    }
    
    /**
     * Calculates and returns the time duration of the task.
     * @return the time duration of the task
     */
    public double getTime() {
        return to - from;
    }

    /**
     * Returns the name corresponding to the type ID of the task.
     * @param typeid the type ID of the task
     * @return the name corresponding to the type ID
     */
    public String typeName(int typeid) {
        String typeName = "";
        switch(typeid) {
            case 1:
                typeName = "Code";
                break;
            case 2:
                typeName = "Test";
                break;
            case 3:
                typeName = "Design";
                break;
            case 4:
                typeName = "Review";
                break;
        }
        return typeName;
    }    

    /**
     * Returns a string representation of the task.
     * @return a string representation of the task
     */
    @Override
    public String toString() {
        return String.format(" %-5d%-15s%-11s%-14s%-7.1f%-10s%-10s\n",
                getId(),
                getName(),
                typeName(getTypeid()), // Calling typeName method to get the task type name
                getDate(),
                getTime(),
                getAssignee(),
                getReviewer());
    }   
}
