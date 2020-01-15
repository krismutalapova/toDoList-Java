public class View {
    private ToDoList toDoList;

    /**
     * Constructor of View class.
     */
    public View() {
        toDoList = new ToDoList();
    }

/**
 * Print out a Welcome message to the user.
 */
    /**
     * Print out a Welcome message to the user.
     */
    public void printWelcome() {
        System.out.println(Colours.ANSI_BLUE.toString() + "~~~~~~~~~~~~~~~~~~~~~~~" + Colours.ANSI_RESET.toString());
        System.out.println(Colours.ANSI_BLUE.toString() + "Welcome to ToDoList App" + Colours.ANSI_RESET.toString());
        System.out.println(Colours.ANSI_BLUE.toString() + "~~~~~~~~~~~~~~~~~~~~~~~~\n" + Colours.ANSI_RESET.toString());
    }

    /**
     * Print out the main menu to the user.
     */
    public void printOptions() {
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
     * Print a message asking for any input to return to the main menu
     */
    public void printReturnMenu() {
        System.out.println(Colours.ANSI_BLUE.toString() + "Please, press any key to return to the menu :)"
                + Colours.ANSI_RESET.toString());
    }

    /**
     * Print a message for an invalid option chosen by a user
     */
    public void invalidOption() {
        System.out.println(Colours.ANSI_RED + "Sorry invalid option :( " + Colours.ANSI_RESET.toString());
    }

    /**
     * Print a message for an invalid input
     */
    public void invalidInput() {
        System.out.println(Colours.ANSI_RED + "Sorry invalid input :( " + Colours.ANSI_RESET.toString());
    }

    /**
     * Print a message for an invalid date chosen by a user
     */
    public void invalidDate(){
        System.out.println(Colours.ANSI_RED.toString() + "Invalid date, task was not created" +
                Colours.ANSI_RESET.toString());
    }

    /**
     * Print a message for a user to enter a custom name for a project
     */
    public void differentProject(){

        System.out.println(Colours.ANSI_BLUE.toString() + "Or enter another name for your project"
                + Colours.ANSI_RESET.toString());

    }

    /**
     * Print a message for a user to choose which task they want to edit or remove
     */
    public void numberOfTasks(){
        System.out.println(Colours.ANSI_BLUE.toString() + "Choose the number of the task you want to edit or remove" +
                Colours.ANSI_RESET.toString());
    }

    /**
     * Print a message asking to input the task
     */
    public void chooseTask(){
        System.out.println("Add a task");
    }

    /**
     * Print a message asking to input the date
     */
    public void chooseDate(){
        System.out.println("Add a date " + Colours.ANSI_RED.toString()
                + "yyyy-MM-dd" + Colours.ANSI_RESET.toString());
    }

    /**
     * Print a message asking to input the project
     */
    public void chooseProject(){
        System.out.println("Choose a project");
    }

    /**
     * Print a message asking to change the task
     */
    public void changeTask(){
        System.out.println("Change the task name");
    }

    /**
     * Print a message for successful task modifications
     */
    public void changeSuccessful(){
        System.out.println(Colours.ANSI_GREEN.toString() + "Changes have been successfully made"
                + Colours.ANSI_RESET.toString());
    }

    /**
     * Print a message asking to change the due date
     */
    public void changeDate(){
        System.out.println("Enter a new due date " + Colours.ANSI_RED.toString()
                + "yyyy-MM-dd" + Colours.ANSI_RESET.toString());
    }

    /**
     * Print a message asking to change the project
     */
    public void changeProject(){
        System.out.println("Change the task project");
    }

    /**
     * Print a message for task status changed to done
     */
    public void taskDone(){
        System.out.println(Colours.ANSI_GREEN.toString() + "The task is DONE now, "
                + Colours.ANSI_RESET.toString()
                + Colours.ANSI_RED.toString() + "don't forget to save changes at the end"
                + Colours.ANSI_RESET.toString());
    }

    /**
     * Frame for a nicer UI
     */
    public void taskFrame(){
        System.out.println(Colours.ANSI_BLUE.toString() + "^^^^^^^^^^^^^^^^^^^^^^^^^" +
                Colours.ANSI_RESET.toString());
    }
}