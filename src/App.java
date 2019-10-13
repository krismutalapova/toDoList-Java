import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Scanner;


public class App {
    private Scanner userOption;
    ToDoList toDoList;

    public App() {
        userOption = new Scanner(System.in);
        toDoList = new ToDoList();
    }

    public static void main(String args[]) {
        App app = new App();
        app.runApp();
    }

    public void runApp() {
        printWelcome();

        /**
         * Given a command, execute the command.
         * @return true If the command to exit the app is given, false otherwise.
         */

        boolean exit = false;
        while (!exit) {
            printOptions();

            switch (nextStep()) {
                case "1":
                    toDoList.listOfTasksMenu();
                    break;
                case "2":
                    this.collectDataToCreateTask();
                    break;
                case "3":
                    // switch case 1 - modify task, 2 - mark task as done, 3 - remove task
                    break;
                case "4":
                    // to be completed
                    // SAVE task in file and print hejdå
                    exit = true;
                    break;
                default:
                    System.out.println("Sorry invalid option :( ");
                    printReturnMenu();
                    break;
            }
            printReturnMenu();
        }
    }

    /**
     * Print out a Welcome message to the user.
     */
    private void printWelcome() {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Welcome to ToDoList App");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~\n");
    }

    /**
     * Print out a menu to the user.
     */
    protected void printOptions() {
        System.out.println("You have " + toDoList.numberOfTasks(false)+ " to do and "
                + toDoList.numberOfTasks(true)+ " tasks are done\n");
        System.out.println("Pick an option:");
        System.out.println("(1) Show Task List");
        System.out.println("(2) Add New Task");
        System.out.println("(3) Edit Task");
        System.out.println("(4) Save and Quit\n");
        System.out.println("Press 1, 2, 3 or 4\n");
    }

    /**
     * Collect user input.
     */
    private String nextStep() {
        return userOption.nextLine();
    }

    private void printReturnMenu() {
        System.out.println("Please, press any key to return to the menu :)");
        nextStep();
    }

    /**
     * Collect user input in order to create the task.
     */
    public void collectDataToCreateTask() {

        System.out.println("Add a task");
        String taskName = nextStep();

        System.out.println("Add a date (yyyy-MM-dd)");
        String dueDate = nextStep();

        System.out.println("Choose a project");
        String project = nextStep();

        if ( convertDate(dueDate) == null ) {
            System.out.println("Invalid date, task was not created");
        } else {

            Task task = new Task(taskName, convertDate(dueDate), project);
            toDoList.addTaskToList(task);
            System.out.println("Your task is " + task.toString());
        }
    }

    /**
     * Collect accurate due date from the user, which is later than current date.
     */
    public LocalDate convertDate(String date) {
        LocalDate convertedDate;
        try {
            convertedDate = LocalDate.parse(date);
            LocalDate currentDate = LocalDate.now();
            if ( convertedDate.isBefore(currentDate) ) {
                return null;
            }
        } catch (DateTimeException e) {
            return null;
        }
        return convertedDate;
    }

}

