import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.Scanner;

public class ToDoList {
    private ArrayList<Task> myTasks;
    private Scanner scan = new Scanner(System.in);

    public ToDoList() {
        myTasks = new ArrayList<>();

    }

    public void addTaskToList(Task task) {
        myTasks.add(task);
    }

    public void showMenu(int option) {
        if ( option >= 1 && option <= 4 ) {
            switch (option) {
                case 1:
                    System.out.println("Your task list: " + myTasks);

                    break;
                case 2:
                    String taskName;
                    String dueDate;
                    String project;
                    // String[] y=  Task.data();

                    System.out.println("Add a task");
                    taskName = scan.nextLine();
                    System.out.println("Add a date");
                    dueDate = scan.nextLine();
                    System.out.println("Choose a project");
                    project = scan.nextLine();

                    // DATE

                    // Project

                    break;
                case 3:
                    System.out.println("Edit");
                    // add update, mark as done, remove for EDIT option
                    break;
                case 4:
                    System.out.println("Save and Quit");
                    System.out.println("Thank you and good-bye!");
                    break;
                default:
                    System.out.println("Sorry invalid option, choose a number 1, 2, 3 or 4");
            }
        }
    }
}