import java.util.ArrayList;
import java.util.Scanner;

public class ToDoList {
    private String Task;
    private ArrayList<Task> myTasks;
    private Scanner scan = new Scanner(System.in);

    public ToDoList() {
        myTasks = new ArrayList<>();
    }

    public void addTaskToList(Task task) {
        myTasks.add(task);
    }

    public void createTask() {
        System.out.println("Add task ID");
        // int input
        int taskID = scan.nextInt();
        System.out.println("Add task ");
        // String input
        String taskName = scan.nextLine();
        System.out.println("Add a due date for the task ");
        // FIGURE OUT DATE FORMAT!!!
        String dueDate = scan.nextLine();
        System.out.println("Select a project");
        //ADD PROJECTS
        System.out.println("Add task ID");

    }

    public void showMenu(int option) {
        if ( option >= 1 && option <= 4 ) {
            switch (option) {
                case 1:
                    System.out.println("Your task list:");
                    // call method to show the list of added tasks
                    break;
                case 2:
                    String taskName;
                    System.out.println("Add a task");
                    scan.nextLine();
                    taskName = scan.nextLine();

                    int taskID;
                    System.out.println("Add task ID");
                    scan.nextInt();
                    taskID = scan.nextInt();

                    // DATE

                    // Project

                    System.out.println("Your new task: " + taskName + taskID);
                    break;
                case 3:
                    System.out.println("Edit");
                    // add update, mark as done, remove for EDIT option
                    break;
                case 4:
                    System.out.println("Save and Quit");
                    System.out.println("Thank you and good-bye!");
                    break;

            }
        }
    }
}