import java.util.Scanner;


public class App {
    private Scanner userOption = new Scanner(System.in);
    private int option;
    ToDoList toDoList = new ToDoList();
    int opt;

    public static void main(String args[]) {
        App app = new App();
        app.runApp();

    }

    public int runApp() {
        printWelcome();
        printOptions();
        nextStep();

        if ( opt == 1 ) {
            this.showListOfTasks();
        } else if ( opt == 2 ) {
            this.collectDataToCreateTask();
        } else if ( opt == 3 ) {
            toDoList.showMenu(3);
        } else if ( opt == 4 ) {
            toDoList.showMenu(4);
        } else if ( opt >= 5 ) {
            System.out.println("Sorry invalid option, choose a number 1, 2, 3 or 4");
        }
        return 0;


    }


    private void printWelcome() {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Welcome to ToDoList App");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~");
    }

    private void printOptions() {
        // add tasks after +
        System.out.println("You have " + " to do and " + " tasks are done");
        System.out.println("Pick and option");
        // add options
        System.out.println("(1) Show Task List");
        System.out.println("(2) Add New Task");
        System.out.println("(3) Edit Task");
        System.out.println("(4) Save and Quit");
        System.out.println("What do you want to do?");
    }

    private void nextStep() {
        System.out.println("Choose 1, 2, 3, 4");
        opt = userOption.nextInt();
    }

    public ToDoList showListOfTasks(){
       return toDoList;
    }
    public void collectDataToCreateTask() {
        Scanner scanner = new Scanner(System.in);
        String taskName;
        String dueDate;
        String project;

        System.out.println("Add a task");
        taskName = scanner.nextLine();

        System.out.println("Add a date");
        dueDate = scanner.nextLine();

        System.out.println("Choose a project");
        project = scanner.nextLine();

        Task task = new Task(taskName, dueDate, project);
        toDoList.addTaskToList(task);
        System.out.println(task);

    }


}

