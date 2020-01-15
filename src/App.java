import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Scanner;


public class App {
    private Scanner userOption;
    private ToDoList toDoList;
    private TasksReader tasksReader;
    private View view;

    public App() {
        userOption = new Scanner(System.in);
        toDoList = new ToDoList();
        tasksReader = new TasksReader();
        view = new View();

    }

    public static void main(String[] args) {
        App app = new App();
        app.runApp();

    }

    /**
     * Run the application and ask for user input for further action
     */
    private void runApp() {
        view.printWelcome();
        toDoList.savedTasks(tasksReader.getTasks());

        while (true) {
            view.printOptions();

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
                    view.invalidOption();
                    // display an error message if user input != 1, 2, 3 or 4
                    break;
            }
            view.printReturnMenu();
            nextStep();
        }
    }


    /**
     * Collect user input.
     */
    protected String nextStep() {
        return userOption.nextLine();
    }


    /**
     * Collect user input in order to create the task.
     */
    private void collectDataToCreateTask() {
        String taskName;
        String dueDate;
        String project;

        view.chooseTask();
        taskName = nextStep();

        view.chooseDate();
        dueDate = nextStep();

        view.chooseProject();
        project = chooseProject();

        if ( !isValidDate(dueDate) ) {
            view.invalidDate();
        } else {
            Task task = new Task(taskName, convertDate(dueDate), project);
            toDoList.addTaskToList(task);
            System.out.println(task.toString());
        }
    }

    /**
     * Print the list of projects for user to choose from while creating the task or editing it
     *
     * @return the name of the project chosen for the task
     */
    public String chooseProject() {
        String project;
        String[] projects = {"ERRANDS", "SHOPPING", "APPOINTMENTS", "OTHER"};
        for (int i = 0; i < projects.length; i++) {
            System.out.println("(" + (i + 1) + ") " + projects[i]);
        }
        view.differentProject();
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
            view.numberOfTasks();
            index = convertIndexToInt(nextStep());
            if ( index == -1 ) {
                view.invalidInput();
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
                    view.changeTask();
                    toDoList.changeTaskName(index, nextStep());
                    view.changeSuccessful();
                    backToMenu = true;
                    break;
                case "2":
                    view.changeDate();
                    String validDate = nextStep();
                    if ( !isValidDate(validDate) ) {
                       view.invalidDate();
                    } else {
                        toDoList.changeTaskDate(index, convertDate(validDate));
                    }
                    view.changeSuccessful();
                    backToMenu = true;
                    break;
                case "3":
                    view.changeProject();
                    toDoList.changeProject(index, chooseProject());
                    view.changeSuccessful();
                    backToMenu = true;
                    break;
                case "4":
                    view.taskDone();
                    toDoList.changeStatus(index, true);
                    backToMenu = true;
                    break;
                case "5":
                    System.out.println(toDoList.getTheTaskFromTheList(index) + Colours.ANSI_RED.toString()
                            + " has been removed" + Colours.ANSI_RESET.toString());
                    toDoList.removeTask(index);
                    backToMenu = true;
                    break;
                case "6":
                    backToMenu = true;
                    break;
                default:
                    view.invalidOption();
                    modifyTasksMenu();
                    break;
            }
        }
    }

    /**
     * Display a menu for task modification
     */
    private void modifyTasksMenu() {
        view.taskFrame();
        String[] modifications = {"Edit task name", "Edit due date", "Change the project",
                "Mark task as done", "Remove task", "Cancel"};
        for (int i = 0; i < modifications.length; i++) {
            System.out.println("(" + (i + 1) + ") " + modifications[i]);
        }
        view.taskFrame();
    }

    /**
     * Collect due date from the user and parse it to String.
     */
    static LocalDate convertDate(String date) {
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
     *
     * @param date for the project
     * @return true if the date is valid, false otherwise
     */
    public boolean isValidDate(String date) {
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

