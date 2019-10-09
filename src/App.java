public class App {
    boolean exit = false;

    public static void main(String args[]) {
        App app = new App();
        app.runApp();
        app.showMenu();
    }

    public void runApp() {
        printWelcome();
        printOptions();

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
    }
}


