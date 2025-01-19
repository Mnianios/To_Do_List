import java.time.LocalDate;

public class Task {
    private int taskID;
    private String taskName;
    private String taskDate;

    //Default Constructor
    Task() {
        taskName ="Default Task";
        taskID = getTaskID();
        taskDate=null;
    }

    Task(String taskName) {
        this.taskName = taskName;
        taskID = generateID();

    }
    //Getters
    public int getTaskID() {
        return taskID;
    }
    public String getTaskName(){
        return taskName;
    }
    //Setters
    public void setTaskID(int taskID) {
        this.taskID = taskID;
    }
    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    @Override
    public String toString() {
        return taskName+ " Task ID:" + taskID + " Task Date:" + taskDate;
    }
    //Adds a date to the task
    protected String addDate(){
        if (taskDate == null) {
            taskDate = LocalDate.now().toString();
        }
        return taskDate;
    }

    //Generates a unique id for each object
    private int generateID(){
        long timestamp = System.currentTimeMillis(); // System.currentTimeMillis() method
        // returns a long value, which represents the number of milliseconds
        // that have passed since the Unix epoch
        return (taskName.hashCode()) + (int) (timestamp %   Integer.MAX_VALUE);

    }

}



