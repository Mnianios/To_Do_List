import java.util.ArrayList;

public class toDoList {
    private ArrayList<Task> tasks;
    private ArrayList<Task> completedTasks;

    //Default Constructor
    toDoList() {
        tasks = new ArrayList<>();
        completedTasks = new ArrayList<>();

    }
    //Constructor
    toDoList(Task t) {
        this(); //calls default constructor to initialize the array list.
        //checking if the object is null
        if (t == null) {
            throw new NullPointerException("Task is null");
        }
        if (t.getTaskName() == null || t.getTaskName().equals("")) {
            throw new IllegalArgumentException("Task name cannot be null or empty");
        }
        t.addDate();
        tasks.add(t);
    }
    // a Getter for the Array List of tasks.
    public ArrayList<Task> getTasks() {
        return new ArrayList<>(tasks);
    }
    //a Method that adds a task to the Array List and stores the date it was added.
    public void addTask(Task t) {
        if (t == null) {
            throw new NullPointerException("Task is null");
        }
        if (t.getTaskName() == null || t.getTaskName().equals("")) {
            throw new IllegalArgumentException("Task name cannot be null or empty");
        }
        t.addDate();
        tasks.add(t);
    }

    public void completed(Task t) {
        if (t == null || !tasks.contains(t)) {
            System.out.println("Task does not exist in the to-do list.");
            return;
        }
        completedTasks.add(t);
        tasks.remove(t);
        System.out.println("Congratulations for completing [" + t.getTaskName() + "]");
    }

    public void displayCompletedTasks() {
        if (completedTasks.isEmpty()) {
            System.out.println("No tasks have been completed yet.");
            return;
        }
        System.out.println("Completed Tasks:");
        int i = 1;
        for (var T : completedTasks) {
            System.out.println(i + ". " + T.toString());
            ++i;
        }
    }

    public void displayList() {
        int i = 1;
        System.out.println("To Do List:");
        for (var T : tasks) {
            System.out.println(i + "." + T.getTaskName());
            i++;
        }
    }


    @Override
    public String toString() {
        return ("\nto Do List:\n" + tasks);
    }
}