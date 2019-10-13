import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class ToDoList {
    private ArrayList<Task> myTasks;
    private Scanner userInput;

    public ToDoList() {
        myTasks = new ArrayList<>();
        userInput = new Scanner(System.in);
    }

    public void addTaskToList(Task task) {
        myTasks.add(task);
    }

    /**
     * counts the number of tasks added to the list
     *
     * @return long value
     */
    public long numberOfTasks(boolean isComplete) {
        return myTasks.stream()
                .filter(task -> task.isComplete() == isComplete)
                .count();
    }

    /**
     * displays all the added tasks in the list
     */
    public void showListOfTasks() {
        myTasks.stream()
                .map(task -> task.toString())
                .forEach(string -> System.out.println(string));
    }

    /**
     * sorts the list of tasks by their due date
     */
    public void sortListByDate() {
        myTasks.stream()
                .sorted(Comparator.comparing(task -> task.getDueDate()))
                .map(task -> task.toString())
                .forEach(string -> System.out.println(string));
    }

    /**
     * sorts the list of tasks by the project
     */
    public void sortListByProject(){
        myTasks.stream()
                .sorted(Comparator.comparing(task -> task.getProject()))
                .map(task -> task.toString())
                .forEach(string -> System.out.println(string));
    }

    public void listOfTasksMenu() {
        boolean backToMenu = false;
        while (!backToMenu) {

            tasksMenu();
            switch (input()){
                case "1":
                    showListOfTasks();
                    break;
                case "2":
                    sortListByDate();
                    break;
                case "3":
                    sortListByProject();
                    break;
                case "4":
                    backToMenu = true;

                    break;
                default:
                    System.out.println("Sorry invalid option :( ");
                    tasksMenu();
                    break;
            }
            returnToTaskMenu();
        }
    }
    private void tasksMenu(){
        System.out.println("*************************");
        System.out.println("(1) Show all tasks");
        System.out.println("(2) Sort tasks by date");
        System.out.println("(3) Sort tasks by project");
        System.out.println("(4) Return to menu");
        System.out.println("Press 1, 2, 3 or 4");
        System.out.println("*************************\n");
    }

    private String input() {
        return userInput.nextLine();
    }

    private void returnToTaskMenu() {
        System.out.println("Please, press any key to return to the menu :)");
        input();
    }
}