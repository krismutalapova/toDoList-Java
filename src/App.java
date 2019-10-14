import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Scanner;


public class App {
    private Scanner userOption;
    private ToDoList toDoList;
    private TasksReader tasksReader;

    public App(){
      userOption = new Scanner(System.in);
      toDoList = new ToDoList();
      tasksReader = new TasksReader();

    }


    public static void main(String[] args) {
        App app = new App();
        app.runApp();
    }

    /**
     * Run the application and asks for user input for further action
     */
    private void runApp() {
        printWelcome();
        toDoList.savedTasks(tasksReader.getTasks());


        while (true) {
            printOptions();

            switch (nextStep()) {
                case "1":
                    toDoList.listOfTasksMenu();
                    break;
                case "2":
                    collectDataToCreateTask();
                    break;
                case "3":
                   modifyTasks();
                    break;
                case "4":
                    tasksReader.writeIntoFile(toDoList.getMyTasks());
                    return;
                default:
                    System.out.println("Sorry invalid option :( ");
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

        String[] actions = {"(1) Show Task List", "(2) Add New Task", "(3) Edit Task", "(4) Save and Quit"};
        for (int i = 0; i < actions.length; i++) {
            System.out.println(actions[i]);
        }
        System.out.println("\nPress 1, 2, 3 or 4\n");
    }

    /**
     * Collect user input.
     */
    protected String nextStep() {
        return userOption.nextLine();
    }

    protected void printReturnMenu() {
        System.out.println("Please, press any key to return to the menu :)");
        nextStep();
    }

    /**
     * Collect user input in order to create the task.
     */
    private void collectDataToCreateTask() {
        String taskName;
        String dueDate;
        String project;
        
        System.out.println("Add a task");
        taskName = nextStep();

        System.out.println("Add a date (yyyy-MM-dd)");
        dueDate = nextStep();

        System.out.println("Choose a project");
        String[] projects = {"(1) ERRANDS", "(2) SHOPPING", "(3) APPOINTMENTS", "(4) OTHER"};
            for (int i = 0; i<projects.length; i++){
            System.out.println(projects[i]);
            }
        project = nextStep();

        switch (project) {
            case "1":
                project = projects[0];
                break;
            case "2":
                project = projects[1];
                break;
            case "3":
                project = projects[2];
                break;
            case "4":
                project = projects[3];
                break;
            default:
                System.out.println("Your task was automatically moved to OTHER");
                project = projects[3];
                break;
        }

        if (convertDate(dueDate) == null) {
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
    public static LocalDate convertDate(String date) {
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

    public void modifyTasks() {

        boolean backToMenu = false;
        while (!backToMenu) {

            modifyTasksMenu();
            switch (nextStep()) {
                case "1":
                    System.out.println("Here you're going to edit tasks");
                    break;
                case "2":
                    System.out.println("Here you're going to mark tasks as done");
                    break;
                case "3":
                    System.out.println("Here you're going to remove tasks");
                    break;
                case "4":
                    backToMenu = true;

                    break;
                default:
                    System.out.println("Sorry invalid option :( ");
                    modifyTasksMenu();
                    break;
            }
            printReturnMenu();
        }
    }

    private void modifyTasksMenu() {
        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^");
        System.out.println("(1) Edit task");
        System.out.println("(2) Mark task as done");
        System.out.println("(3) Remove task");
        System.out.println("(4) Return to menu");
        System.out.println("Press 1, 2, 3 or 4");
        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^\n");
    }


}

