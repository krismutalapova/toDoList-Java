

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

        boolean exit = false;
        while (!exit) {
            printOptions();

            switch (nextStep()) {
                case "1":
                    toDoList.showListOfTasks();
                    // create switch case for 1 - show list, 2 - sorted by date, 3 - sorted by project, 4 - return tu menu.
                    toDoList.sortListByDate();
                    break;
                case "2":
                    this.collectDataToCreateTask();
                    break;
                case "3":
                    // to be completed
                    break;
                case "4":
                    // to be completed
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

    private void printReturnMenu() {
        System.out.println("Please, press any key to return to the menu :)");
        nextStep();
    }

    private void printWelcome() {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Welcome to ToDoList App");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~");
    }

    private void printOptions() {
        // add tasks after +
        System.out.println("You have " + toDoList.numberOfTasks(false)+ " to do and "
                + toDoList.numberOfTasks(true)+ " tasks are done");
        System.out.println("Pick an option");
        // add options
        System.out.println("(1) Show Task List");
        System.out.println("(2) Add New Task");
        System.out.println("(3) Edit Task");
        System.out.println("(4) Save and Quit");
        System.out.println("What do you want to do?");
        System.out.println("Choose 1, 2, 3, 4\n");
    }

    private String nextStep() {
        //System.out.println("");
        return userOption.nextLine();
    }


    public void collectDataToCreateTask() {
        String taskName;
        String dueDate;
        String project;

        System.out.println("Add a task");
        taskName = nextStep();

        System.out.println("Add a date");
        dueDate = nextStep();

        System.out.println("Choose a project");
        project = nextStep();

        if ( convertDate(dueDate) == null ) {
            System.out.println("Invalid date, task was not created");
        } else {

            Task task = new Task(taskName, convertDate(dueDate), project);
            toDoList.addTaskToList(task);
            System.out.println("Your task is " + task.toString());
        }
    }

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

