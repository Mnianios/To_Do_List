import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    private static final Scanner scanner = new Scanner(System.in);

    public static void displayMenu(toDoList list) {
        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Add a task");
            System.out.println("2. Complete a task");
            System.out.println("3. Display tasks");
            System.out.println("4. Display completed tasks");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            try {
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1 -> {
                        System.out.print("Enter task name: ");
                        String taskName = scanner.nextLine();
                        try {
                            list.addTask(new Task(taskName));
                            System.out.println("Task added successfully!");
                        } catch (IllegalArgumentException | NullPointerException e) {
                            System.out.println("Error: " + e.getMessage());
                        }
                    }
                    case 2 -> {
                        System.out.println("Enter the task number to mark as completed: ");
                        try {
                            int taskNumber = Integer.parseInt(scanner.nextLine());
                            ArrayList<Task> taskList = list.getTasks();
                            if (taskNumber > 0 && taskNumber <= taskList.size()) {
                                list.completed(taskList.get(taskNumber - 1));
                            } else {
                                System.out.println("Error: Invalid task number.");
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Error: Please enter a valid number.");
                        } catch (Exception e) {
                            System.out.println("Error: " + e.getMessage());
                        }
                    }
                    case 3 -> list.displayList();
                    case 4 -> list.displayCompletedTasks();
                    case 5 -> {
                        System.out.println("Exiting program. Goodbye!");
                        return;
                    }
                    default -> System.out.println("Invalid choice. Try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Please enter a valid menu option.");
            } catch (Exception e) {
                System.out.println("An unexpected error occurred: " + e.getMessage());
            }
        }
    }
}