import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Scanner;


public class App {
    private Scanner userOption;
    private ToDoList toDoList;
    private TasksReader tasksReader;

    public App() {
        userOption = new Scanner(System.in);
        toDoList = new ToDoList();
        tasksReader = new TasksReader();

    }

    public static void main(String[] args) {
        App app = new App();
        app.runApp();

    }

    /**
     * Run the application and ask for user input for further action
     */
    private void runApp() {
        printWelcome();
        toDoList.savedTasks(tasksReader.getTasks());

        while (true) {
            printOptions();

            switch (nextStep()) {
                case "1":
                    toDoList.listOfTasksMenu(); // show the menu for sorting tasks by date or project
                    break;
                case "2":
                    collectDataToCreateTask();
                    break;
                case "3":
                    modifyTasks(); // show the menu for task modification and removal
                    break;
                case "4":
                    tasksReader.writeIntoFile(toDoList.getMyTasks()); // save the tasks into file
                    return;
                default:
                    System.out.println(Colours.ANSI_RED + "Sorry invalid option :( " + Colours.ANSI_RESET.toString());
                    // display an error message if user input != 1, 2, 3 or 4
                    break;
            }
            printReturnMenu();
        }
    }

    /**
     * Print out a Welcome message to the user.
     */
    private void printWelcome() {

        System.out.println(Colours.ANSI_BLUE.toString() + "~~~~~~~~~~~~~~~~~~~~~~~" + Colours.ANSI_RESET.toString());
        System.out.println(Colours.ANSI_BLUE.toString() + "Welcome to ToDoList App" + Colours.ANSI_RESET.toString());
        System.out.println(Colours.ANSI_BLUE.toString() + "~~~~~~~~~~~~~~~~~~~~~~~~\n" + Colours.ANSI_RESET.toString());
    }

    /**
     * Print out the main menu to the user.
     */
    protected void printOptions() {
        System.out.println("You have " + Colours.ANSI_RED.toString() + toDoList.numberOfTasks(false) +
                Colours.ANSI_RESET.toString() + " tasks to do and " + Colours.ANSI_GREEN.toString() +
                toDoList.numberOfTasks(true) + Colours.ANSI_RESET.toString() + " tasks are done\n");
        System.out.println(Colours.ANSI_BLUE.toString() + "Pick an option:" + Colours.ANSI_RESET.toString());

        String[] actions = {"(1) Show Task List", "(2) Add New Task", "(3) Edit Task", "(4) Save changes and Quit"};
        for (int i = 0; i < actions.length; i++) {
            System.out.println(actions[i]);
        }
        System.out.println(Colours.ANSI_BLUE.toString() + "\nPress 1, 2, 3 or 4\n" + Colours.ANSI_RESET.toString());
    }

    /**
     * Collect user input.
     */
    protected String nextStep() {
        return userOption.nextLine();
    }

    /**
     * Print a message asking for any input to return to the main menu
     */
    protected void printReturnMenu() {
        System.out.println(Colours.ANSI_BLUE.toString() + "Please, press any key to return to the menu :)"
                + Colours.ANSI_RESET.toString());
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

        System.out.println("Add a date " + Colours.ANSI_RED.toString()
                + "yyyy-MM-dd" + Colours.ANSI_RESET.toString());
        dueDate = nextStep();

        System.out.println("Choose a project");
        project = chooseProject();

        if ( !isValidDate(dueDate) ) {
            System.out.println(Colours.ANSI_RED.toString() + "Invalid date, task was not created" +
                    Colours.ANSI_RESET.toString());
        } else {
            Task task = new Task(taskName, convertDate(dueDate), project);
            toDoList.addTaskToList(task);
            System.out.println(task.toString());
        }
    }

    /**
     * Print the list of projects for user to choose from while creating the task or editing it
     * @return the name of the project chosen for the task
     */

    public String chooseProject() {
        String project;
        String[] projects = {"ERRANDS", "SHOPPING", "APPOINTMENTS", "OTHER"};
        for (int i = 0; i < projects.length; i++) {
            System.out.println("(" + (i + 1) + ") " + projects[i]);
        }
        System.out.println("(5) Or enter another name for your project");
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
                project = project.toUpperCase();
                break;
        }
        return project;
    }

    /**
     * Print the menu for task modification and edit or remove task
     */
    private void modifyTasks() {
        toDoList.printTasksWithIndex(); //display message asking user to choose a task number
        boolean wrongIndex = false; //validate the user input (is number or not)
        int index = 0;
        while (!wrongIndex) {
            System.out.println(Colours.ANSI_BLUE.toString() + "Choose the number of the task you want to edit or remove" +
                    Colours.ANSI_RESET.toString());
            index = convertIndexToInt(nextStep());
            if ( index == -1 ) {
                System.out.println(Colours.ANSI_RED.toString() + "Sorry, invalid input" + Colours.ANSI_RESET.toString());
            } else {
                wrongIndex = true;
            }
        }
        //show the chosen task
        System.out.println(toDoList.getTheTaskFromTheList(index));

        boolean backToMenu = false;
        //then show the edit options
        modifyTasksMenu();
        while (!backToMenu) {

            switch (nextStep()) {
                case "1":
                    System.out.println("Change the task name");
                    toDoList.changeTaskName(index, nextStep());
                    System.out.println(Colours.ANSI_GREEN.toString() + "Task name has been changed"
                            + Colours.ANSI_RESET.toString());
                    backToMenu = true;
                    break;
                case "2":
                    System.out.println("Enter a new due date " + Colours.ANSI_RED.toString()
                            + "yyyy-MM-dd" + Colours.ANSI_RESET.toString());
                    String validDate = nextStep();
                    if (!isValidDate(validDate)) {
                        System.out.println(Colours.ANSI_RED.toString() + "Invalid date, task was not created" +
                                Colours.ANSI_RESET.toString());
                    } else {
                        toDoList.changeTaskDate(index, convertDate(validDate));
                    }
                    System.out.println(Colours.ANSI_GREEN.toString() + "Due date has been changed"
                            + Colours.ANSI_RESET.toString());
                    backToMenu = true;
                    break;
                case "3":
                    System.out.println("Change the task project");
                    toDoList.changeProject(index, chooseProject());
                    System.out.println(Colours.ANSI_GREEN.toString() + "Project has been changed"
                            + Colours.ANSI_RESET.toString());
                    backToMenu = true;
                    break;
                case "4":
                    System.out.println(Colours.ANSI_GREEN.toString() + "The task is DONE now, "
                            + Colours.ANSI_RESET.toString()
                            + Colours.ANSI_RED.toString() + "don't forget to save changes at the end"
                            + Colours.ANSI_RESET.toString());
                    toDoList.changeStatus(index, true);
                    backToMenu = true;
                    break;
                case "5":
                    System.out.println(Colours.ANSI_RED.toString() + "Your task " + Colours.ANSI_RESET.toString()
                            + toDoList.getTheTaskFromTheList(index) + Colours.ANSI_RED.toString()
                            + " has been removed" + Colours.ANSI_RESET.toString());
                    toDoList.removeTask(index);
                    backToMenu = true;
                    break;
                case "6":
                    backToMenu = true;
                    break;
                default:
                    System.out.println(Colours.ANSI_RED.toString() + "Sorry invalid option :( "
                            + Colours.ANSI_RESET.toString());
                    modifyTasksMenu();
                    break;
            }
        }
    }

    /**
     * Display a menu for task modification
     */
    private void modifyTasksMenu() {
        System.out.println(Colours.ANSI_BLUE.toString() + "^^^^^^^^^^^^^^^^^^^^^^^^^" +
                Colours.ANSI_RESET.toString());
        String[] modifications = {"Edit task name", "Edit due date", "Change the project",
                "Mark task as done", "Remove task", "Cancel"};
        for (int i = 0; i < modifications.length; i++) {
            System.out.println("(" + (i + 1) + ") " + modifications[i]);
        }
        System.out.println(Colours.ANSI_BLUE.toString() + "^^^^^^^^^^^^^^^^^^^^^^^^^\n" +
                Colours.ANSI_RESET.toString());
    }

    /**
     * Collect due date from the user and parse it to String.
     */
    public static LocalDate convertDate(String date) {
        LocalDate convertedDate;
        try {
            convertedDate = LocalDate.parse(date);

        } catch (DateTimeException e) {
            return null;
        }
        return convertedDate;
    }

    /**
     * Validate if due date is later than current date, when user creates or edits the task
     * @param date for the project
     * @return true if the date is valid, false otherwise
     */
    private boolean isValidDate(String date) {
        LocalDate convertedDate;
        try {
            convertedDate = LocalDate.parse(date);
            LocalDate currentDate = LocalDate.now();
            if ( convertedDate.isBefore(currentDate) ) {
                return false;
            }
        } catch (DateTimeException e) {
            return false;
        }
        return true;
    }

    /**
     * Collect accurate user input, that can be turned into int, otherwise return -1
     */
    public int convertIndexToInt(String index) {
        int convertedIndex;
        try {
            convertedIndex = Integer.parseInt(index) - 1;
            if ( convertedIndex < 0 && convertedIndex >= toDoList.sizeOfTheList() ) {
                return -1;
            }
        } catch (NumberFormatException e) {
            return -1;
        }
        return convertedIndex;
    }
}

